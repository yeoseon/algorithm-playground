package Solutions;

import java.util.ArrayList;
import java.util.List;

public class MockExam {

    /**
     * 1. 각 반복되는 패턴이 있다.
     * 2. 문제번호 % 반복 패턴 개수의 값이 답이 된다. 이게 같은 것을 찾아본다.
     * 3. 1,2,3번 수포자가 각각 맞힌 수를 배열로 구성한다 (?)
     * 4. 맞힌 수 중 최대값을 산출한다.
     * 5. List를 Array로 변환한다. 이때 Stream을 이용해보자.
     */

    private static final int[] PATTERN_ONE = {1, 2, 3, 4, 5};
    private static final int[] PATTERN_TWO = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] PATTERN_THREE = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] scores = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == PATTERN_ONE[i % PATTERN_ONE.length]) {
                scores[0]++;
            }
            if(answers[i] == PATTERN_TWO[i % PATTERN_TWO.length]) {
                scores[1]++;
            }
            if(answers[i] == PATTERN_THREE[i % PATTERN_THREE.length]) {
                scores[2]++;
            }
        }

        int maxScore = getMaxScore(scores);
        List<Integer> firstGradeList = new ArrayList<>();

        for(int i = 0; i < scores.length; i++) {
            if(scores[i] == maxScore) {
                firstGradeList.add(i + 1);
            }
        }

        return firstGradeList.stream()
                .mapToInt(number -> number).toArray();
    }

    private int getMaxScore(int[] scores) {
        return Math.max(scores[0], Math.max(scores[1], scores[2]));
    }
}
