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

        // 배포날짜들을 구하자마자 Queue에 넣어서 for문을 한번 줄이자.
        Queue<Integer> releaseDayQueue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {

            // 아래 처럼 일일이 if문으로 분기하지 않고, Math.ceil(올림)을 이용한다.
            if (speeds[i] > 100 - progresses[i]) {
                releaseDayQueue.add(1);
                continue;
            }
            releaseDayQueue.add((int) Math.ceil((100 - progresses[i]) / speeds[i]));
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

    public int[] practice1(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();

        Queue<Integer> releaseDays = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {

            if(100 - progresses[i] < speeds[i]) {
                releaseDays.add(1);
                continue;
            }
            releaseDays.add((int) Math.ceil((100 - progresses[i]) / speeds[i]));
        }

        while(!releaseDays.isEmpty()) {
            int releaseCount = 0;
            int releaseDay = releaseDays.poll();
            releaseCount++;

            while(!releaseDays.isEmpty() && releaseDay >= releaseDays.peek()) {
                releaseDays.remove();
                releaseCount++;
            }
            answerList.add(releaseCount);
        }

        return answerList.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
