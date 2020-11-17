package Solutions;

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
}
