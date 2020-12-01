package Solutions;

import java.util.Arrays;

public class IntegerTriangle {
    /**
     *
     * - 탐욕법을 통해 무조건 현재 상황에서 큰 수를 찾아가기에는 최댓값이 나오지 않는다.
     * - 결국은 다 구해봐야 한다는 소리인가 그럼 DFS가 되는데
     * -> 메모이제이션을 이용한 동적계획법을 사용해보자. DFS에 메모이제이션을 추가해서!
     *
     * sum[i][j] = sum[i][j] + sum[i-1][j] 또는
     * sum[i][j] = sum[i][j] + sum[i-1][j+1]
     *
     * - 재귀를 이용해서 DFS로 풀으려고 했지만 실패했다.
     * - 현재의 sum값을 알려면 이전 값이 모두 채워져있어야 하지만, 재귀를 사용하다 보니 그렇게 하지 못했다.
     * - 재귀가 아니라 for문으로 풀자.
     * - j=i라면 굳이 triangle[i].length - 1 이런거 쓸 필요 없이 i로만 써주면 됨
     *
     * @param triangle
     * @return
     */
    public int solution1(int[][] triangle) {
        Integer[][] sum = new Integer[triangle.length][triangle[triangle.length - 1].length];

        sum[0][0] = triangle[0][0];

        for(int i=1; i < triangle.length; i++) {
            sum[i][0] = triangle[i][0] + sum[i-1][0];
            sum[i][triangle[i].length-1] = triangle[i][triangle[i].length-1] + sum[i-1][triangle[i].length-2];
        }

        for(int i = 2; i < triangle.length; i++) {
            for(int j = 1; j < triangle[i].length-1; j++) {
                sum[i][j] = triangle[i][j] + Math.max(sum[i-1][j-1], sum[i-1][j]);
            }
        }

        Arrays.sort(sum[triangle.length - 1]);
        return sum[triangle.length - 1][triangle[triangle.length - 1].length - 1];
    }
}
