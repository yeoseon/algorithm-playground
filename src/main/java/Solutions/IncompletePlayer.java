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
            if(completionList.indexOf(participant[i]) == -1) {
                return participant[i];
            }

            else {
                completionList.remove(completionList.indexOf(participant[i]));
            }
        }

        return answer;
    }
}
