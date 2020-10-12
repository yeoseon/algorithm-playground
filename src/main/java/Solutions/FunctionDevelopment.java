package Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {

    /**
     * 1. 일단 배포에 걸리는 일수 부터 계산한다.
     *  1.1 Speed > 남은 일수
     *      1.1.1 --> 1일
     *  1.2 else
     *      1.2.1 남은 일수 % Speed != 0 --> 남은 일수 / Speed + 1
     *      1.2.2 남은 일수 % Speed == 0 --> 남은 일수 / Speed
     * 2. 배포에 걸리는 일수를 Queue에 넣는다.
     * 3. 답을 구한다. (While(!Queue.isEmpty())
     *  3.0 배포개수 변수를 0으로 설정한다. 매번 poll하거나 remove할 때에는 배포개수 +1을 한다.
     *  3.1 배포 첫날 처음 요소는 poll하여 변수에 저장. (배포개수 +1)
     *  3.2 하나씩 poll 하기 전, peek해서, 변수에 저장된 첫 요소보다 작거나 같은지 확인한다.
     *      3.2.1 작으면 remove하고, 배포개수 +1
     *      3.2.2 하나라도 큰게 나오면 break 하고 정답 List에 add한다.
     * 4. List to Array
     * @param progresses
     * @param speeds
     * @return
     */
    public int[] solution1(int[] progresses, int[] speeds) {


        // 실제 배포되는 날짜 목록 구하기
        int[] releaseDays = new int[progresses.length];

        for(int i = 0; i < progresses.length; i++) {
            int leftDays = 100 - progresses[i];
            if(speeds[i] > leftDays) {
                releaseDays[i] = 1;
            }
            else {
                releaseDays[i] = leftDays / speeds[i];

                if(leftDays % speeds[i] != 0) {
                    releaseDays[i] = releaseDays[i] + 1;
                }
            }
        }

        // 배포날짜들 Queue에 넣기
        Queue<Integer> releaseDayQueue = new LinkedList<>();

        for(int releaseDay : releaseDays) {
            releaseDayQueue.add(releaseDay);
        }

        // 정답 구하기
        List<Integer> answerList = new ArrayList<>();

        while(!releaseDayQueue.isEmpty()) {
            int releaseCount = 0;       // 하루의 배포 개수

            int firstReleaseDay = releaseDayQueue.poll();    // 하루의 처음 배포되는 서비스의 ReleaseDay
            releaseCount++;

            while(!releaseDayQueue.isEmpty() && releaseDayQueue.peek() <= firstReleaseDay) {
                releaseDayQueue.remove();
                releaseCount++;
            }
            answerList.add(releaseCount);
        }

        return answerList.stream()
                .mapToInt(i -> i)
                .toArray();
    }

}
