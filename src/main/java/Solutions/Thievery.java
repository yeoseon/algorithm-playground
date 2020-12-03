package Solutions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Thievery {

    /**
     *
     * 잘못된 풀이임. 탐욕법으로 풀리지 않음
     *
     * 큰 돈을 훔치면서, 인접한 집을 털지 않는 경우를 select 한다.
     *
     * 탐욕법을 이용하자.
     * 1. 가장 큰 수의 집부터 방문한다.
     * 2. 인접한 두 요소 외 집 중에서 가장 큰 수의 집을 방문한다.
     * 3. 큰 수를 만날 경우, 해당 수의 인접한 곳에 이미 턴 곳이 있는지 확인한다.
     *
     * maxMoney 인접한 곳에 visited 한 집이 있는지 확인한다.
     * 없을 경우 stolenMoney에 더해준다.
     * maxMoney와 인접집에는 방문할 수 없도록 액수를 0으로 바꾼다.
     * 방문할 수 있는 집이 없을 때 종료한다.
     * @param money
     * @return
     */
    public int solution1(int[] money) {
        int stolenMoney = 0;

        List<Integer> moneyList = Arrays.stream(money).boxed()
                                        .collect(Collectors.toList());


        while(!isVisitAllHome(moneyList)) {
            int maxMoney = moneyList.stream()
                    .max(Integer::compareTo)
                    .get();

            stolenMoney += maxMoney;
            int maxMoneyIndex = moneyList.indexOf(maxMoney);

            moneyList.set(maxMoneyIndex, 0);

            if(maxMoneyIndex > 0) {
                moneyList.set(maxMoneyIndex - 1, 0);
            }
            else {
                moneyList.set(moneyList.size() - 1, 0);
            }

            if(maxMoneyIndex < moneyList.size() - 1) {
                moneyList.set(maxMoneyIndex + 1, 0);
            }
            else {
                moneyList.set(0, 0);
            }
        }

        return stolenMoney;
    }

    private boolean isVisitAllHome(List<Integer> moneyList) {
        for(int i = 0; i < moneyList.size(); i++) {
            if(moneyList.get(i) != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 동적 계획법을 이용해서 풀어야 한다.
     *
     * 첫번째 집을 턴 경우와 두번째 집을 턴 경우를 고려한다.
     *
     * @param money
     * @return
     */
    public int solution2(int[] money) {
        int length = money.length;
        int[] dp1 = new int[length];
        int[] dp2 = new int[length];

        dp1[0] = money[0];
        dp1[1] = money[0];
        dp2[1] = money[1];


        for(int i = 2; i < length; i++) {
            dp1[i] = Math.max(dp1[i-2]+money[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2]+money[i], dp2[i-1]);
        }

        return Math.max(dp1[length-2], dp2[length-1]);
    }
}
