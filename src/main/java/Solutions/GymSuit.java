package Solutions;

import java.util.Arrays;

public class GymSuit {

    /**
     * 탐욕법
     * 본인 기준으로 앞 번호나 뒷 번호를 선택해서 있는 경우 체육복을 빌려준다.
     * https://velog.io/@delay/JAVA-%EC%B2%B4%EC%9C%A1%EB%B3%B5-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4
     * @param n
     * @param lost
     * @param reserve
     * @return
     */
    public int solution1(int n, int[] lost, int[] reserve) {
        int[] all = new int[n];

        for(int i : reserve) {
            all[i - 1]++;
        }
        for(int i : lost) {
            all[i - 1]--;
        }
        for(int i = 0; i < all.length; i++) {
            if(all[i] < 0) {
                if( i != all.length - 1 && all[i+1] > 0) {
                    all[i]++;
                    all[i+1]--;
                }
                else if(i != 0 && all[i - 1] > 0) {
                    all[i]++;
                    all[i-1]--;
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < all.length; i++) {
            if(!(all[i] < 0)) {
                answer++;
            }
        }
        return answer;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int[] s = new int[n];
        Arrays.fill(s, 1);          // 학생은 체육복은 무조건 1개씩 가지고 있어야 하므로 1로 채워준다.

        // for(int i : lost) s[i - 1] -= 1; 과 같다.
        for(int i = 0; i < lost.length; i++) {
            int studentNumber = lost[i];
            int studentIndex = studentNumber - 1;
            s[studentIndex] -= 1;
        }


        // for(int i : reserve) s[i - 1] += 1; 과 같다.
        for(int i = 0; i < reserve.length; i++) {
            int studentNumber = reserve[i];
            int studentIndex = studentNumber - 1;
            s[studentIndex] += 1;
        }

        for(int i = 0; i < n; i++) {
            if(s[i] <= 1) continue;

            if(i > 0 && s[i-1] < 1) {
                s[i-1] += 1;
                s[i] -= 1;
            } else if(i < n-1 && s[i+1] < 1) {
                s[i+1] += 1;
                s[i] -= 1;
            }
        }

        int anwser = 0;

        //for(int i = 0; i < n; i++) anwser += s[i] >= 1 ? 1 : 0; 과 같다.
        for(int i = 0; i < n; i++) {
            if(s[i] >= 1) {
                anwser += 1;
            } else {
                anwser += 0;
            }
        }

        return anwser;
    }
}
