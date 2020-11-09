package Solutions;

import java.util.ArrayList;
import java.util.List;

public class WordConversion {

    /**
     * 1. target 단어가 words 안에 없으면 0을 반환한다.
     * 2. 한번 변환된 단어는 다시 변환되지 않도록 목록에서 삭제하면서 계산한다.
     * 3. 단어 하나만 다른 단어가 있는지 검사한 후, 그 단어에 대해 또 재귀로 검사한다.
     *
     * https://tosuccess.tistory.com/29 참고
     *
     * @param begin
     * @param target
     * @param words
     * @return
     */
    public int solution1(String begin, String target, String[] words) {
        List<Integer> steps = new ArrayList<>();
        Integer[] visited = new Integer[words.length];

        // target 단어가 words에 포함되지 않을 경우 0 리턴
        if(!hasTarget(target, words)) {
            return 0;
        }

        dfs(begin, target, words, visited, 0, steps);

        return steps.stream()
                .min(Integer::compareTo).get();
    }

    private void dfs(String begin, String target, String[] words, Integer[] visited, int step, List<Integer> steps) {
        if(visitedAllWord(visited)) {
            return ;
        }
        if(begin.equals(target)) {
            steps.add(step);
            return ;
        }

        for(int j = 0; j < words.length; j++) {
            int count = 0;
            for(int i = 0; i < begin.length(); i++) {
                if(begin.charAt(i) != words[j].charAt(i)) {
                    count++;
                }
            }
            if(count == 1 && visited[j] == null) {
                visited[j] = 1;
                dfs(words[j], target, words, visited, step + 1, steps);
                visited[j] = null;
            }
        }
    }

    private boolean visitedAllWord(Integer[] visited) {
        int count = 0;
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == null) {
                count++;
            }
        }
        return count == 0;
    }

    private boolean hasTarget(String target, String[] words) {
        int count = 0;

        for(String word : words) {
            if(target.equals(word)) {
                count++;
            }
        }

        if(count == 0) {
            return false;
        }

        return true;
    }
}
