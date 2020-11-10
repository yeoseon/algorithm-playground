package Solutions;

import java.util.ArrayList;
import java.util.List;

public class GameMapShortestDistance {

    /**
     * DFS를 이용하여 구현한다.
     *
     * @param maps
     * @return
     */
    public int solution1(int[][] maps) {
        int answer = -1;
        List<Integer> distanceList = new ArrayList<>();
        Integer[][] visited = new Integer[maps.length][maps[0].length];

        dfs(maps, new Point(0, 0, maps[0][0]), visited, 1, distanceList);

        return distanceList.stream()
                .min(Integer::compareTo)
                .orElse(-1);
    }

    private void dfs(int[][] maps, Point currentPoint, Integer[][] visited, int currentDistance, List<Integer> distanceList) {
        if(currentPoint.isOpposingPoint(maps)) {
            distanceList.add(currentDistance);
            return ;
        }
        if(!currentPoint.canGoAnywhere(maps, visited)) {
            return ;
        }

        if(currentPoint.canGoRight(maps, visited)) {
            Point pointToGo = currentPoint.goRight(maps);
            visited[pointToGo.getX()][pointToGo.getY()] = 1;
            dfs(maps, pointToGo, visited, currentDistance + 1, distanceList);
            visited[pointToGo.getX()][pointToGo.getY()] = null;
        }
        if(currentPoint.canGoLeft(maps, visited)) {
            Point pointToGo = currentPoint.goLeft(maps);
            visited[pointToGo.getX()][pointToGo.getY()] = 1;
            dfs(maps, pointToGo, visited, currentDistance + 1, distanceList);
            visited[pointToGo.getX()][pointToGo.getY()] = null;
        }
        if(currentPoint.canGoDown(maps, visited)) {
            Point pointToGo = currentPoint.goDown(maps);
            visited[pointToGo.getX()][pointToGo.getY()] = 1;
            dfs(maps, pointToGo, visited, currentDistance + 1, distanceList);
            visited[pointToGo.getX()][pointToGo.getY()] = null;
        }
        if(currentPoint.canGoUp(maps, visited)) {
            Point pointToGo = currentPoint.goUp(maps);
            visited[pointToGo.getX()][pointToGo.getY()] = 1;
            dfs(maps, pointToGo, visited, currentDistance + 1, distanceList);
            visited[pointToGo.getX()][pointToGo.getY()] = null;
        }
    }

    class Point {
        private int x;
        private int y;
        private int wall;

        public Point(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }

        public Point goRight(int[][] maps) {
            return new Point(x, y+1, maps[x][y+1]);
        }

        public Point goLeft(int[][] maps) {
            return new Point(x, y-1, maps[x][y-1]);
        }

        public Point goUp(int[][] maps) {
            return new Point(x-1, y, maps[x-1][y]);
        }

        public Point goDown(int[][] maps) {
            return new Point(x+1, y, maps[x+1][y]);
        }

        public boolean canGoRight(int[][] map, Integer[][] visited) {
            if(isDeadEnd(map, x, y+1)) {
                return false;
            }
            if(isVisited(visited, x, y+1)) {
                return false;
            }
            return map[x][y+1] == 1;
        }

        public boolean canGoLeft(int[][] map, Integer[][] visited) {
            if(isDeadEnd(map, x, y-1)) {
                return false;
            }
            if(isVisited(visited, x, y-1)) {
                return false;
            }
            return map[x][y-1] == 1;
        }

        public boolean canGoUp(int[][] map, Integer[][] visited) {
            if(isDeadEnd(map, x-1, y)) {
                return false;
            }
            if(isVisited(visited, x-1, y)) {
                return false;
            }
            return map[x-1][y] == 1;
        }

        public boolean canGoDown(int[][] map, Integer[][] visited) {
            if(isDeadEnd(map, x+1, y)) {
                return false;
            }
            if(isVisited(visited, x+1, y)) {
                return false;
            }
            return map[x+1][y] == 1;
        }

        public boolean canGoAnywhere(int[][] map, Integer[][] visited) {
            return canGoRight(map, visited) || canGoLeft(map, visited) || canGoUp(map, visited) || canGoDown(map, visited);
        }

        private boolean isVisited(Integer[][] visited, int x, int y) {
            return visited[x][y] != null && visited[x][y] == 1;
        }

        /**
         * 막다른 길인지 여부 반환
         * @param map
         * @param x
         * @param y
         * @return
         */
        public boolean isDeadEnd(int[][] map, int x, int y) {
            if(x == -1 || x >= map.length) {
                return true;
            }
            if(y == -1 || y >= map[x].length) {
                return true;
            }
            return false;
        }

        public boolean isOpposingPoint(int[][] map) {
            return x+1 == map.length && y+1 == map[0].length;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
