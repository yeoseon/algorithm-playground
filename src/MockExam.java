import java.util.ArrayList;
import java.util.List;

public class MockExam {

    // 1번 수포자: 문제 번호 % 5, 0일 땐 5
    // 2번 수포자: 홀수 번호는 무조건 2, 짝수는 % 8 = (2: 1), (4: 3), (6: 4), (0: 5)
    // 3번 수포자: 문제 번호 % 10 = (1,2 : 3), (3,4: 1), (5,6: 2), (7,8: 4), (9,0: 5)
    public int[] solution(int[] answers) {
        int[] answer = {};

        int count1 = getCountCorrect1(answers);
        int count2 = getCountCorrect2(answers);
        int count3 = getCountCorrect3(answers);

        return getMaxCount(count1, count2, count3);
    }

    private int getCountCorrect1(int[] answers) {
        int count = 0;

        for(int i = 0; i < answers.length; i++) {
            if(i % 5 != 0) {
                if(answers[i] == i % 5) {
                    count++;
                }
            }
            else {
                if(answers[i] == 5) {
                    count++;
                }
            }
        }
        return count;
    }

    private int getCountCorrect2(int[] answers) {
        int count = 0;

        for(int i = 0; i < answers.length; i++) {
            if(i % 2 == 1) {
                if(answers[i] == 2) {
                    count++;
                }
            }
            else {
                if(i % 8 == 2) {
                    if(answers[i] == 1) {
                        count++;
                    }
                }
                else if(i % 8 == 4) {
                    if(answers[i] == 3) {
                        count++;
                    }
                }
                else if(i % 8 == 6) {
                    if(answers[i] == 4) {
                        count++;
                    }
                }
                else if(i % 8 == 0) {
                    if(answers[i] == 5) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int getCountCorrect3(int[] answers) {
        int count = 0;

        for(int i = 0; i < answers.length; i++) {
            if(i % 10 == 1 || i % 10 == 2) {
                if(answers[i] == 3) {
                    count++;
                }
            }
            else if(i % 10 == 3 || i % 10 == 4) {
                if(answers[i] == 1) {
                    count++;
                }
            }
            else if(i % 10 == 5 || i % 10 == 6) {
                if(answers[i] == 2) {
                    count++;
                }
            }
            else if(i % 10 == 7 || i % 10 == 8) {
                if(answers[i] == 4) {
                    count++;
                }
            }
            else {
                if(answers[i] == 5) {
                    count++;
                }
            }
        }
        return count;
    }

    private int[] getMaxCount(int count1, int count2, int count3) {
        int[] countResult = {count1, count2, count3};
        int[] result = new int[3];
        List<Integer> tempResult = new ArrayList<>();

        int maxCount = countResult[0];

        for(int i = 0; i < countResult.length; i++) {
            if(maxCount < countResult[i]) {
                maxCount = countResult[i];
            }
        }

        for(int i = 0; i < countResult.length; i++) {
            if(countResult[i] == maxCount) {
                tempResult.add(i + 1);
            }
        }

        int size = 0;
        for(int temp : tempResult) {
            result[size++] = temp;
        }
        return result;
    }
}
