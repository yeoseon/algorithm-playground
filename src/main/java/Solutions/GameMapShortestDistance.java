package Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameMapShortestDistance {

    /**
     * DFS를 이용하여 구현한다.
     *
     * @param maps
     * @return
     */
    public int solution1(int[][] maps) {
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

    /**
     * BFS를 이용해서 구현한다.
     * BFS는 너비 우선이기 때문에, 빠르게 도착하면 바로 끝낼 수 있어서 더 효율적이다.
     * https://lightsky1992.tistory.com/23
     * @param maps
     * @return
     */
    public int solution2(int[][] maps) {
        Integer[][] visited = new Integer[maps.length][maps[0].length];

        return bfs(maps, new Point2(0, 0, maps[0][0], 1), visited);
    }

    private int bfs(int[][] maps, Point2 currentPoint, Integer[][] visited) {

        Queue<Point2> queue = new LinkedList<>();
        queue.add(currentPoint);

        while(!queue.isEmpty()) {
            Point2 point = queue.poll();
            visited[point.getX()][point.getY()] = 1;

            if(point.canGoRight(maps, visited)) {
                Point2 pointToGo = point.goRight(maps);
                queue.add(pointToGo);
            }
            if(point.canGoLeft(maps, visited)) {
                Point2 pointToGo = point.goLeft(maps);
                queue.add(pointToGo);
            }
            if(point.canGoDown(maps, visited)) {
                Point2 pointToGo = point.goDown(maps);
                queue.add(pointToGo);
            }
            if(point.canGoUp(maps, visited)) {
                Point2 pointToGo = point.goUp(maps);
                queue.add(pointToGo);
            }

            if(visited[maps.length-1][maps[0].length-1] != null && visited[maps.length-1][maps[0].length-1] == 1) {
                return point.getDistance();
            }
        }

        return -1;
    }

    class Point2 {
        private int x;
        private int y;
        private int wall;
        private int distance;

        public Point2(int x, int y, int wall, int distance) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.distance = distance;
        }

        public Point2 goRight(int[][] maps) {
            return new Point2(x, y+1, maps[x][y+1], distance+1);
        }

        public Point2 goLeft(int[][] maps) {
            return new Point2(x, y-1, maps[x][y-1], distance+1);
        }

        public Point2 goUp(int[][] maps) {
            return new Point2(x-1, y, maps[x-1][y], distance+1);
        }

        public Point2 goDown(int[][] maps) {
            return new Point2(x+1, y, maps[x+1][y], distance+1);
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

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }
    }
}
