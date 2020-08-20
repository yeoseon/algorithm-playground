package Solutions;

import java.util.Arrays;

public class KthNumber {

    /**
     * 1. 배열을 자른다.
     * 2. 해당 배열을 정렬한다.
     * 3. K - 1 번째 수를 가져온다.
     */
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;

        for(int i = 0; i < commands.length; i++) {
            answer[idx] = solve(array, commands[i]);
            idx++;
        }
        return answer;
    }

    public static int solve(int[] array, int[] command) {
        int result = 0;
        int[] subArray = subArray(array, command[0], command[1]);

        Arrays.sort(subArray);
        return subArray[command[2] - 1];
    }

    public static int[] subArray(int[] array, int start, int end) {
        int[] result = new int[end - start + 1];
        int idx = 0;

        for (int i = start; i <= end; i++) {
            result[idx] = array[i - 1];
            idx++;
        }
        return result;
    }
}
