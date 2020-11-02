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
        int count = 0;

        count += recursion(numbers, target, 0, numbers.length, 0);

        return count;
    }

    /**
     *
     * @param numbers : 주어진 배열
     * @param target : 만들고자 하는 숫자
     * @param index : 더하고자 하는 배열 index
     * @param r : 남은 수. 0이 되면 재귀를 종료한다.
     * @param sum : 현재까지의 합
     */
    private int recursion(int[] numbers, int target, int index, int r, int sum) {
        if(r == 0) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        int positiveSum = numbers[index] + sum;
        int negativeSum = numbers[index]*(-1) + sum;

        int ans = 0;
        ans += recursion(numbers, target, index + 1, r - 1, positiveSum);
        ans += recursion(numbers, target, index + 1, r - 1, negativeSum);

        return ans;
    }
}
