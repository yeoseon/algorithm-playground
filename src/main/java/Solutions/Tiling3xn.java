package Solutions;

public class Tiling3xn {
    static final int MOD = 1000000007;

    /**
     * F(1) = 0
     * F(2) = 3
     * F(4) = 9(F(2)*3) + 2(n-4칸 에서만 만들 수 있는 특수한 경우의 수) = 11
     * F(5) = 0
     * F(6) =
     *
     * -> F(n) = (F(n-2) * 3) + (F(n-4) * 2)
     *
     * 이해하기 쉽지 않다.
     * https://zin0-0.tistory.com/31
     * https://yabmoons.tistory.com/471
     * https://uyoo-story.tistory.com/22
     * 홀수의 경우는 무조건 0이다.
     * n=2일 경우 경우의 수는 3이다.
     * 이 4의 배수가 될 때마다 2가지의 경우가 추가된다.
     *
     * @param n
     * @return
     */
    public int solution1(int n) {
        int answer = 0;
        int mod = 1000000007;
        long[] dp = new long[5001];

        dp[0] = 1;
        dp[2] = 3;
        for(int i=4; i<=n; i+=2){
            dp[i] = dp[i-2] * 3;
            for(int j=i-4; j>=0; j-=2){
                dp[i] += dp[j] * 2;
            }
            dp[i] = dp[i] % mod;
        }

        answer = (int) dp[n];
        return answer;
    }
}
