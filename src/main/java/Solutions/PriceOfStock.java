package Solutions;

import java.util.ArrayList;
import java.util.List;

public class PriceOfStock {

    /**
     * i = 1부터 시작한다.
     *
     * 1. 끝까지 안떨어지는 경우 (최소 숫자)
     * => length - i
     * 2. 떨어지는 경우 (뒤에 최초로 작은 숫자가 나온다면)
     * => 작은 숫자의 i - 나의 i
     *
     * index 와 value를 다뤄보면 되지 않을까?
     *
     * @param prices
     * @return
     */
    public int[] solution1(int[] prices) {
        List<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < prices.length; i++) {
            boolean isDown = false;
            for(int j = i+1; j < prices.length; j++) {
                if(prices[j] < prices[i]) {
                    answerList.add(j - i);
                    isDown = true;
                    break;
                }
            }
            if(!isDown) {
                answerList.add(prices.length - i - 1);
            }
        }

        return answerList.stream()
                    .mapToInt(i -> i)
                    .toArray();
    }
}
