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
}
