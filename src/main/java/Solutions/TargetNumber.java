package Solutions;

import java.util.ArrayList;
import java.util.List;

public class TargetNumber {

    /**
     * +와 -를 붙힌 2가지의 경우로 재귀를 호출한다. 모든 경우의 수를 더한 후 target이 되는 경우 count++ 한다.
     * @param numbers
     * @param target
     * @return
     */
    public int solution1(int[] numbers, int target) {
        List<Integer> count = new ArrayList<>();

        recursion(numbers, target, count, 0, numbers.length, 0);

        return count.size();
    }

    /**
     *
     * @param numbers : 주어진 배열
     * @param target : 만들고자 하는 숫자
     * @param count : 만들고자 하는 숫자에 부합하는 경우의 수
     * @param index : 더하고자 하는 배열 index
     * @param r : 남은 수. 0이 되면 재귀를 종료한다.
     * @param sum : 현재까지의 합
     */
    private void recursion(int[] numbers, int target, List<Integer> count, int index, int r, int sum) {
        if(r == 0) {
            if(sum == target) {
                count.add(1);
            }
            return ;
        }

        int positiveSum = numbers[index] + sum;
        int negativeSum = numbers[index]*(-1) + sum;

        recursion(numbers, target, count, index + 1, r - 1, positiveSum);
        recursion(numbers, target, count, index + 1, r - 1, negativeSum);
    }
}
