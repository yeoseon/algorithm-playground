package Solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
 *
 * 해시 알고리즘
 */
public class IncompletePlayer {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, String> hash = new HashMap<String, String>();

        for(int i = 0; i < completion.length; i++) {
            hash.put(completion[i], completion[i]);
        }

        for(int j = 0; j < participant.length; j++) {
            if(hash.get(participant[j]) == null) {
                return participant[j];
            }
            else {
                hash.remove(participant[j]);
            }
        }
        return answer;
    }
}
