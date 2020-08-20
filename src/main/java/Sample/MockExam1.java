package Sample;

import java.util.ArrayList;

/**
 * 풀이 방법
 * - 반복되는 1 Term을 배열로 선언해둔다.
 * - 해당 배열의 길이만큼이 나눌 값이 되는 것
 * 1. Math.max() API를 이용해 최대값을 한번에 뽑아냈다.
 * 2. Java 8의 Stream을 이용하여 Collection을 배열로 넣어주었다.
 */
class MockExam1 {
    public int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}