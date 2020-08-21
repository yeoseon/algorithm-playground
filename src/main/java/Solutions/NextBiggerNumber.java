package Solutions;

public class NextBiggerNumber {

    private static final String ONE = "1";

    /**
     * N보다 크고, 2진수 변환시 1의 개수가 같은 수를 구한다.
     * N보다 큰 수에 대해서 1씩 더해서 검사해본다.
     * N보다 큰 수 내의 for문을 돌리고, 값이 나오는 순간 Break 처리 한다.
     * String을 배열로 변환하여, for문을 돌리면서 1의 개수를 센다. (비효율적이진 않을까?)
     */
    public static int solution(int n) {
        int answer = 0;

        String nToBinary = Integer.toBinaryString(n);

        for(int i = n+1; ; i++) {
            if(getCountOne(nToBinary) == getCountOne(Integer.toBinaryString(i))) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    private static int getCountOne(String binary) {
        return getCountOne(binary.split(""));
    }

    private static int getCountOne(String[] binaryArray) {
        int count = 0;

        for(String number : binaryArray) {
            if(ONE.equals(number)) {
                count++;
            }
        }

        return count;
    }
}
