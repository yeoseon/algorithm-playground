package Solutions;

import java.util.Stack;

/**
 * 탑
 * https://programmers.co.kr/learn/courses/30/lessons/42588
 *
 * 스택/큐
 */
public class Top {

    public static int[] solution(final int[] heights) {
        final int[] answer = new int[heights.length];
        final Stack<Integer> stack = new Stack<>();

        // Stack에 탑 높이 정보 쌓기
        for (final int height : heights) {
            stack.push(height);
        }

        // 레이저 신호 발사가 가능한지 여부 검사하기
        while (!stack.empty()) {
            // 검사할 항목 pop
            final int item = stack.pop();

            for(int i = stack.size()-1; i >= 0; i--) {
                if(item < heights[i]) {
                    // answer에는 height 값이 들어가는 것이 아니라, 탑의 위치 정보가 들어간다.
                    answer[stack.size()] = i+1;
                    break;
                }
            }
        }
        return answer;
    }
}
