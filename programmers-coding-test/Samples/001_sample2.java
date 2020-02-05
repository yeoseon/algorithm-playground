package Samples;

/**
 * 완주하지 못한 선수 문제의 모범답안 02 (해시 이용 X, sort 이용)
 */

import java.util.*;

class Solution001Sample2 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for ( i=0; i<completion.length; i++){

            if (!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }
}