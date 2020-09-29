package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthNumber {

    /**
     * 1. 배열을 자른다.
     * 2. 해당 배열을 정렬한다.
     * 3. K - 1 번째 수를 가져온다.
     */
    public static int[] solution1(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;

        for(int i = 0; i < commands.length; i++) {
            answer[idx] = solve(array, commands[i]);
            idx++;
        }
        return answer;
    }

    public static int solve(int[] array, int[] command) {
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

    /**
     * 1. commands의 i만큼 for문을 돌려 구한다.
     * 2. 배열을 자른다.
     * 3. k번째의 수를 구한다.
     * @param array
     * @param commands
     * @return
     */
    public static int[] solution2(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i];

            int[] subArray = subArray2(array, command[0], command[1]);
            Arrays.sort(subArray);
            answerList.add(subArray[command[2] - 1]);
        }

        return answerList.stream()
                .mapToInt(x -> x)
                .toArray();
    }

    private static int[] subArray2(int[] array, int start, int end) {
        int[] subArray = new int[end - start + 1];
        int idx = 0;

        for(int i = start - 1; i < end; i++) {
            subArray[idx] = array[i];
            idx++;
        }

        return subArray;
    }
}
