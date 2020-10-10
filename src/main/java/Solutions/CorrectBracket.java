package Solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     */
    public boolean solution1(String s) {

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
                numberForResult++;
            }
            if(RIGHT_BRACKET.equals(queue.poll())) {
                numberForResult--;
            }
        }

        return numberForResult == 0;
    }

    /**
     * Solution 2 : 효율성 테스트 실패
     * Stack을 이용한다.
     * 1. (가 들어올 때는 push
     * 2. )가 들어올 때는 pop - 이 때 Stack이 비어있으면 false
     * 3. 최종적으로 Stack이 비어있지 않아도 false
     *
     * -> for문 내의 stack에서 push, pop 하는 과정이 효율성을 잡아먹는다. -> Stack을 쓸 필요가 없다.
     *
     * @param s
     * @return
     */
    public boolean solution2(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    /**
     * Solution 3
     *
     * solution2의 stack 대신 int를 사용한다.
     * @param s
     * @return
     */
    public boolean solution3(String s) {

        int stack = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack++;
            }
            else {
                if(stack == 0) {
                    return false;
                }
                stack--;
            }
        }

        return stack == 0;
    }
}
