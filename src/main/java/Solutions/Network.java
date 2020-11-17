package Solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        boolean[] isCheck = new boolean[n];     // 굳이 List로 할 필요 없이, Node들이 검사가 되었는지만 보면 됐었다.

        for(int node = 0; node < n; node++) {
            if(!isCheck[node]) {
                search3(node, computers, isCheck);
                searchCount++;
            }
        }

        return searchCount;
    }

    private boolean[] search(int node, int[][] computers, boolean[] isCheck) {
        isCheck[node] = true;

        for(int i = 0; i < computers.length; i++) {
            if(i != node && computers[node][i] == 1 && !isCheck[i]) {
                search(i, computers, isCheck);
            }
        }

        return isCheck;
    }

    /**
     * BFS 이용하여 풀이 (강의 참고)
     * @param node
     * @param computers
     * @param isCheck
     */
    private void search2(int node, int[][] computers, boolean[] isCheck) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            int c = queue.poll();
            for(int i = 0; i < computers[node].length; i++) {
                if(isCheck[i]) continue;
                if(computers[c][i] == 1) {
                    isCheck[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    /**
     * Stack을 이용한 DFS로 풀이 (강의 참고)
     * @param node
     * @param computers
     * @param isCheck
     */
    private void search3(int node, int[][] computers, boolean[] isCheck) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            int c = stack.pop();
            for(int i = 0; i < computers[c].length; i++) {
                if(isCheck[i]) continue;
                if(computers[c][i] == 1) {
                    isCheck[i] = true;
                    stack.push(i);
                }
            }
        }
    }
}
