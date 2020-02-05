import java.util.*;

class Solution002Sample2 {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for (int i=0; i<heights.length; i++){
            for (int j=i+1; j<heights.length; j++){
                if (heights[i] > heights[j]){
                    answer[j]=i+1;
                }
            }
        }


        return answer;
    }
}