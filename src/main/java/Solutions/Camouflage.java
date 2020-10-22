package Solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Camouflage {

    /**
     * 개수만 리턴하면 되므로 조합의 수를 integer만을 이용해서 구할 수 있다.
     * (n + 1) * (m + 1) * (o + 1) * (p + 1) - 1 (-1은 하나도 안입는 경우의 수)
     * headgear를 한다면 headgear의 경우의 수는 headgear의 개수 + headgear에서 아예 안하는 개수(1) = 2 + 1
     * https://2ssue.github.io/algorithm/programmers_42578/
     * @param clothes
     * @return
     */
    public int solution1(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothesMap = new HashMap<>();

        for(String[] clothe : clothes) {
            clothesMap.put(clothe[1], clothesMap.getOrDefault(clothe[1], 0) + 1);
        }

        // 조합 구하기
        Set<String> keySet = clothesMap.keySet();

        for(String key : keySet) {
            answer *= clothesMap.get(key) + 1;
        }

        return answer - 1;
    }
}
