/**
 * 하샤드 수
 * https://school.programmers.co.kr/courses/10586/lessons/67676?language=java
 */
public class HashedNumber {

    public static boolean solution(int x) {
        int xCopy = x;
        int sum = 0;

        while(xCopy > 0) {
            sum += xCopy % 10;
            xCopy = xCopy / 10;
        }

        return (x % sum == 0);
    }
}
