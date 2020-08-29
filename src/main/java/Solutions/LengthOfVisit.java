package Solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LengthOfVisit {

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point move(int xToMove, int yToMove) {
            int resultX = this.x;
            int resultY = this.y;

            if(Math.abs(this.x + xToMove) <= 5) {
                resultX = this.x + xToMove;
            }
            if (Math.abs(this.y + yToMove) <= 5) {
                resultY = this.y + yToMove;
            }

            return new Point(resultX, resultY);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public class Points {
        Point[] points;

        public Points(Point[] points) {
            this.points = points;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Points points1 = (Points) o;
            return Arrays.equals(points, points1.points);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(points);
        }
    }

    public enum Direction {
        U("U", 0, 1),
        D("D", 0, -1),
        R("R", 1, 0),
        L("L", -1, 0);

        private String dir;
        private int x;
        private int y;

        Direction(String dir, int x, int y) {
            this.dir = dir;
            this.x = x;
            this.y = y;
        }

        public Point move(Point startPoint) {
            for(Direction direction : Direction.values()) {
                if(direction.dir.equals(dir)) {
                    return startPoint.move(direction.x, direction.y);
                }
            }
            throw new IllegalArgumentException(dir + "은 적합하지 않은 Direction 입니다.");
        }
    }

    public int solution(String dirs) {
        String[] directions = dirs.split("");
        Set<Points> visitHistory = new HashSet<>();

        Point point = new Point(0, 0);

        for(int i = 0; i < directions.length; i++) {
            Direction direction = Direction.valueOf(directions[i]);
            saveVisitHistory(visitHistory, point, direction);
            point = direction.move(point);
        }

        return visitHistory.size();
    }

    private void saveVisitHistory(Set<Points> visitHistory, Point point, Direction direction) {
        if(!point.equals(direction.move(point))) {
            Point[] points = {point, direction.move(point)};
            visitHistory.add(new Points(points));
            points = null;
        }
    }
}
