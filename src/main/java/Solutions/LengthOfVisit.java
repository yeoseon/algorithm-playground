package Solutions;

import java.util.HashSet;
import java.util.Set;

public class LengthOfVisit {

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 기존 Point에 pointToMove만큼 움직인 Point를 반환한다.
        public Point getMovedPoint(Point pointToMove) {
            return new Point(this.x + pointToMove.getX(), this.y + pointToMove.getY());
        }

        private int getX() {
            return this.x;
        }

        private int getY() {
            return this.y;
        }
    }

    public enum Direction {
        UP("U", 0, 1),
        DOWN("D", 0, -1),
        RIGHT("R", 1, 0),
        LEFT("L", 0, -1);

        private String dir;
        private int x;
        private int y;

        Direction(String dir, int x, int y) {
            this.dir = dir;
            this.x = x;
            this.y = y;
        }

        public Point move(Point startPoint, String dir) {
            for(Direction direction : Direction.values()) {
                if(direction.equals(dir)) {
                    return startPoint.getMovedPoint(new Point(direction.x, direction.y));       //TODO: 왜 static?
                }
            }
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
     */
    public int solution(String dirs) {
        int answer = 0;

        String[] directions = dirs.split("");
        Set<Point[]> visitHistory = new HashSet<>();

        Point zeroPoint = new Point(0, 0);

        for(int i = 0; i < directions.length; i++) {

        }

        return answer;
    }
}
