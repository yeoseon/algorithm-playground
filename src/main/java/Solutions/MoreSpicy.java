package Solutions;

import java.util.PriorityQueue;
/**
 * 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 *
 * 힙(Heap)
 */
public class MoreSpicy {

    public int solution1(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int aScoville : scoville) {
            heap.offer(aScoville);
        }

        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            int a = heap.poll();
            int b = heap.poll();
            int result = a + (b * 2);

            heap.offer(result);
            answer ++;
        }
        return answer;
    }

    /**
     * 내가 안보고 다시 푼 예제
     * 힙 -> 우선순위 큐를 이용한다.
     * @param scovilles
     * @param K
     * @return
     */
    public int solution2(int[] scovilles, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int scoville : scovilles) {
            priorityQueue.add(scoville);
        }

        while(priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) {
                return -1;
            }

            int min = priorityQueue.poll();
            int secondMin = priorityQueue.poll();

            priorityQueue.add(min + (secondMin * 2));
            answer++;
        }

        return answer;
    }
}
