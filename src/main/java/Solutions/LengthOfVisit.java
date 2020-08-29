package Solutions;

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

    /**
     * 왔던 길을 중복하지 않도록 처리하기 위해서는, 현재의 Point 뿐만 아니라 그 전의 Point도 기억해야 한다.
     * Point 클래스를 만들어보자
     * Set을 이용하고, 이중 배열을 이용해보자. (?)
     * 객체 지향적으로 개선해봐도 좋을 듯 하다.
     * Enum을 활용하는 것도 해보자.
     *
     * U: y+1, D: y-1, R: x+1, L: x-1
     * x,y 값의 절대값이 5보다 커지는 경우 이동하지 않는다.
     *
     * 1. 입력받은 dirs를 ,로 split 하여 배열로 갖는다.
     * 2. for문을 돌며 Set에 경로를 저장한다.
     * 3. Set의 개수를 도출한다.
     *
     * 고민점: Point 객체는 new할 때마다 새로운 객체로 생성이 될 텐데.. Set에 저장한다고 해서 History 관리가 안될 것이다.
     * 기본 자료형을 다뤄야 하나?
     *
     * 문제 1. : Point가 갱신되고 있지 않음
     * Set 내부에서 Point[]를 모두 다른 객체로 취급하고 있음
     */
    public int solution(String dirs) {
        String[] directions = dirs.split("");
        Set<Point[]> visitHistory = new HashSet<>();

        Point point = new Point(0, 0);

        for(int i = 0; i < directions.length; i++) {
            Direction direction = Direction.valueOf(directions[i]);
            saveVisitHistory(visitHistory, point, direction);
            point = direction.move(point);
        }

        return visitHistory.size();
    }

    private void saveVisitHistory(Set<Point[]> visitHistory, Point point, Direction direction) {
        Point[] points = {point, direction.move(point)};
        visitHistory.add(points);
        points = null;
    }
}
