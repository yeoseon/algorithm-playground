package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class CorrectBracket {

    private static final String LEFT_BRACKET = "(";
    private static final String RIGHT_BRACKET = ")";

    /**
     * **틀린 답안임**
     * 1. Queue를 이용해서 먼저 s 목록을 Queue에 넣는다.
     * 2. 하나씩 pop 하면서 맨 처음과 마지막을 검사한다.
     * 3. int를 통해 +와 -를 반복하여 0을 만드는지 검사한다.
     *
     * -> 3번으로 하면 s5와 같은 예외 케이스가 있다.
     * Stack을 이용했어야 한다!
     * Queue를 이용한 생각도 좋았지만, 일단 문제 풀이를 할 수 없는 구조이고
     * 문제를 푼다 해도, for문 돌려서 하는 것과 별반 달라보이지 않는다.
     *
     * @param s
     * @return
     */
    boolean solution1(String s) {

        if(!LEFT_BRACKET.equals(String.valueOf(s.charAt(0)))) {
            return false;
        }
        if(!RIGHT_BRACKET.equals(String.valueOf(s.charAt(s.length() - 1)))) {
            return false;
        }

        Queue<String> queue = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            queue.add(String.valueOf(s.charAt(i)));
        }

        int numberForResult = 0;

        while (!queue.isEmpty()) {
            if(LEFT_BRACKET.equals(queue.poll())) {
            if(LEFT_BRACKET.equals(queue.poll())) {
                numberForResult++;
            }
            if(RIGHT_BRACKET.equals(queue.poll())) {
                numberForResult--;
            }
        }

        return numberForResult == 0;
    }
}
