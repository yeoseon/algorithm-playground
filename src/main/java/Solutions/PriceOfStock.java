package Solutions;

public class PriceOfStock {

    /**
     * Solution 1 : 단순 풀이
     *
     * i = 0부터 시작한다.
     *
     * 1. 끝까지 안떨어지는 경우 (최소 숫자)
     * => length - i - 1
     * 2. 떨어지는 경우 (뒤에 최초로 작은 숫자가 나온다면)
     * => 작은 숫자의 i - 나의 i
     *
     *
     * @param prices
     * @return
     */
    public int[] solution1(int[] prices) {
//        List<Integer> answerList = new ArrayList<>();
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            boolean isDown = false;
            for(int j = i+1; j < prices.length; j++) {
                if(prices[j] < prices[i]) {
//                    answerList.add(j - i);
                    answer[i] = j - i;
                    isDown = true;
                    break;
                }
            }
            if(!isDown) {
//                answerList.add(prices.length - i - 1);
                answer[i] = prices.length - i - 1;
            }
        }

//        return answerList.stream()
//                    .mapToInt(i -> i)
//                    .toArray();
        return answer;
    }

    /**
     * Solution2 : Stack 이용
     *
     *
     * @param prices
     * @return
     */
    public int[] solution2(int[] prices) {
        int[] anwser = {};


        return anwser;
    }
}
