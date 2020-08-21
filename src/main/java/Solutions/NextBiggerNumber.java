package Solutions;

public class NextBiggerNumber {

    private static final String ONE = "1";

    /**
     * Best Solution
     * Interger 객체에서 제공하는 bitCount를 사용한다.
     * while문을 활용하고, for문내의 if문으로 사용했던 조건을 While문으로 넣어서 전환해본다.
     */
    public static int solution1(int n) {
        int nextBigNumber = n + 1;

        while(Integer.bitCount(n) != Integer.bitCount(nextBigNumber)) {
            nextBigNumber++;
        }

        return nextBigNumber;
    }

    /**
     * 나의 첫 풀이
     * N보다 크고, 2진수 변환시 1의 개수가 같은 수를 구한다.
     * N보다 큰 수에 대해서 1씩 더해서 검사해본다.
     * N보다 큰 수 내의 for문을 돌리고, 값이 나오는 순간 Break 처리 한다.
     * String을 배열로 변환하여, for문을 돌리면서 1의 개수를 센다. (비효율적이진 않을까?)
     */
    public static int solution2(int n) {
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

        for (String number : binaryArray) {
            if (ONE.equals(number)) {
                count++;
            }
        }

        return count;
    }
}
