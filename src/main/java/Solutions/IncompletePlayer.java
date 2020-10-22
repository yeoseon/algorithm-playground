package Solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 *
 * 해시 알고리즘
 */
public class IncompletePlayer {
    public String solution1(String[] participant, String[] completion) {
        String answer = "";
        Map<String, String> hash = new HashMap<String, String>();

        for(int i = 0; i < completion.length; i++) {
            hash.put(completion[i], completion[i]);
        }

        for(int j = 0; j < completion.length; j++) {
            if(hash.get(participant[j]) == null) {
                return participant[j];
            }
            else {
                hash.remove(participant[j]);
            }
        }
        return answer;
    }

    /**
     * 다시 풀어보기
     *
     * 1. 완주자 명단과 참석자 명단을 copy한다.
     * 2. 하나씩 비교하면서 remove 한다.
     * 3. 남은 선수를 return 한다.
     *
     * List의 indexOf를 먼저 생각해서 일단 구현해봤다.
     *
     * 정답은 통과했으나, indexOf API를 사용해서 인지, 효율성에서는 통과하지 못했다.
     * @param participant
     * @param completion
     * @return
     */
    public String solution2(String[] participant, String[] completion) {
        String answer = "";

        List<String> completionList = new ArrayList<>();

        for(int i = 0; i < completion.length; i++) {
            completionList.add(completion[i]);
        }

        for(int i = 0; i < completion.length; i++) {
            if(completionList.indexOf(participant[i]) == -1) {      // 사실 불필요한 로직. 바로 remove해도 됨
                return participant[i];
            }

            else {
                completionList.remove(completionList.indexOf(participant[i]));      //remove는 하나하나 찾아가면서 remove 시키므로, 효율성에서 좋지 않다.
            }
        }

        return answer;
    }

    /**
     * Hash를 이용한 풀이 : Index를 통해 바로 찾고 싶을 때
     * 동명 이인이 있으므로 Set은 사용할 수 없다. Map을 쓰자
     * getOrDefault() 함수 이용
     * https://codevang.tistory.com/289 참고
     * @param participants
     * @param completions
     * @return
     */
    public String solution3(String[] participants, String[] completions) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for(String participant : participants) {
            map.put(participant, map.getOrDefault(participant, 0) + 1);
        }

        for(String completion : completions) {
            map.put(completion, map.get(completion) - 1);
        }

        // entry.getKey를 사용하는 것이 map.getKey()를 사용하는 것보다 좋다.
        // map.getKey()를 사용할 경우, 해당 key를 찾기 위해 한번 더 순환하기 때문이다.
        // 따라서 Entry 자체를 통해 가져오는 것이 더 빠르다.
        // https://codevang.tistory.com/289 참고
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }

    /**
     * 0이나 1로 채우지 않고, remove 시켜버려서, 마지막 남은 즉, 첫번쨰 요소를 return 하는 것도 방법이다.
     * 이때 첫번쨰 요소 반환시 사용하는 stream은 아래와 같다.
     *
     * map.keySet().stream().findFirst().get();
     */
}
