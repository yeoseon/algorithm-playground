package Solutions;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Network {
    /**
     * 혼자 고민해본 로직
     *
     * 깊이우선탐색을 통해 1개씩 탐색한다.
     * 그 과정에서 지나온 길을 모두 저장한다.
     * 1개씩 탐색할 때, 지나온 길에 이미 포함되어 있을 경우, 탐색하지 않는다.
     * 최종 탐색 Count 를 반환한다.
     *
     * 풀이
     * 1. Computer의 개수만큼 for문을 돌린다.
     * 2. 탐색 History 변수를 하나 선언한다.
     * 3. dfs 로직을 구현해서, 탐색하며 탐색 History에 insert한다.
     * 4. 탐색하려는 Computer가 탐색 History에 이미 포함되어 있는 경우, dfs로직을 타지 않는다.
     * 5. dfs 로직을 탐과 동시에 탐색 Count ++1
     * 6. 최종적으로 탐색 Count를 반환한다.
     *
     * 고민
     * 깊이 우선 탐색일 필요는 없겠다.
     * @param n
     * @param computers
     * @return
     */
    public int solution1(int n, int[][] computers) {
        int searchCount = 0;
        Set<Integer> searchHistory = new HashSet<>();

        for(int node = 0; node < n; node++) {
            if(!searchHistory.contains(node)) {
                search(node, computers, searchHistory);
                searchCount++;
            }
        }

        return searchCount;
    }

    private Set<Integer> search(int node, int[][] computers, Set<Integer> searchHistory) {
        searchHistory.add(node);

        for(int i = 0; i < computers.length; i++) {
            if(i != node && computers[node][i] == 1 && !searchHistory.contains(node)) {
                search(i, computers, searchHistory);
            }
        }

        return searchHistory;
    }
}
