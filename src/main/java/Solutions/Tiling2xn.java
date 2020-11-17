package Solutions;

public class Tiling2xn {
    /**
     * https://deveric.tistory.com/61
     * F(1) = 1, F(n) = 2
     * 점화식 : F(n-3) = (F(n-1) + F(n-2)) * F(1) -> F(n-3) = F(n-1) + F(n-2)
     * -> 피보나치 수열
     * @param n
     * @return
     */
    public int solution1(int n) {
        int a = 1;  // n - 1
        int b = 1;  // n - 2

        for(int i = 0; i < n - 1; i++) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return b;
    }

    static final int MOD = 1000000007;

    public int solution2(int n) {
        int[] d = new int[n+1];

        d[0] = 0;
        d[1] = 1;
        d[2] = 2;

        for(int i = 3; i <= n; i++) {
            d[i] = (d[i-1] + d[i-2]) % MOD;
        }

        return d[n];
    }
}
