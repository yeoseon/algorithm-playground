package Solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RamenFactory {
    /**
     * 최소한의 횟수로 받아야 하기에, 필수로 받야아 하는 날에 받은 후, 물량 공급 가능 수가 큰 순서로 받는다. (최대한 날짜를 뒤로 미룬다.)
     * 남은 K 보다 크고, K 이후 공급받아 생긴 stock보다 작은 날짜 사이의 가능 일 수 중, 공급 가능 수가 큰 날짜로 고른다.
     * https://gurumee92.tistory.com/172
     *
     * 하루씩 재고를 소진해 가다가 공급날이 되면 재고큐에 값을 넣고, 재고가 떨어지는 날에 재고를 가져오는 식으로 K 날까지 반복하는 방식
     * 우선순위 힙을 이용한다.
     *
     * @param stock
     * @param dates
     * @param supplies
     * @param k
     * @return
     */
    public int solution1(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        for(int i = 0; i < k; i++) {
            if(index < dates.length && i == dates[index]) {
                queue.add(supplies[index++]);
            }

            if(stock == 0) {
                stock += queue.poll();
                answer++;
            }
            stock--;
        }
        return answer;
    }
}
