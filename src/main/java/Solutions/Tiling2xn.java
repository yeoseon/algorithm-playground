package Solutions;

public class Tiling2xn {
    /**
     * https://deveric.tistory.com/61
     *
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
}
