package Solutions;

import java.util.ArrayList;
import java.util.List;

public class MakingPrimeNumber {

    /**
     * solution1 : 단순 풀이
     * 3중 포문을 이용해 모두 더한다.
     * @param nums
     * @return
     */
    public int solution1(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(isPrimeNumber1(nums[i] + nums[j] + nums[k])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    /**
     * isPrimeNumber1 - 소수 판별 함수 1
     * 1을 제외한 모든 수를 나눠서 판단한다.
     * 시간 복잡도는 O(N)
     * @param number
     * @return
     */
    public boolean isPrimeNumber1(int number) {
        if(number <= 1) {
            return false;
        }

        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * isPrimeNumber2 - 소수 판별 함수 2
     * 해당 숫자의 절반까지만 확인하는 방법
     * 절반 이상의 숫자는 확인이 필요 없다.
     * 이 또한 시간복잡도는 O(N)이 된다. - N/2번 조회
     *
     * @param number
     * @return
     */
    public boolean isPrimeNumber2(int number) {
        if(number <= 1) {
            return false;
        }

        for(int i = 2; i <= number/2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * isPrimeNumber3 - 소수 판별 함수 3
     * 제곱근을 이용한다. - https://st-lab.tistory.com/80
     * 시간 복잡도는 O(sqrt(N))이 된다.
     * @param number
     * @return
     */
    public boolean isPrimeNumber3(int number) {
        if(number <= 1) {
            return false;
        }

        for(int i = 2; i*i <= number; i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * makePrimeNumber - 소수 판별 함수 4
     * 에라토스테네스의 체 (https://marobiana.tistory.com/91, https://st-lab.tistory.com/80)
     * 이 방법은, 소수 여부를 판별하기 보다는 현재 모든 수 중 소수만을 걸러서 구하는 상황에 쓰인다.
     * 현재 문제에서는 true/false 여부만 알면 되기 때문에 사용하지는 않지만, 참고 용으로 Sample 코드를 가져온다.
     *
     * @param number
     * @return
     */
    public void makePrimeNumber(int number) {
        boolean[] primeArray = new boolean[3001];

        for (int i = 2; i < primeArray.length; i++) {
            primeArray[i] = true;
        }

        for (int i = 2; i < primeArray.length; i++) {
            for (int j = i * i; j < primeArray.length; j += i)
                primeArray[j] = false;
        }
    }
}
