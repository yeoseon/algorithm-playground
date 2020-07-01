package Sample;

import java.util.LinkedList;
class MockExam3 {
    public int[] solution(int[] answers) {
        int[] m = new int[3];
        int[] supo1 = { 1, 2, 3, 4, 5 };
        int[] supo2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] supo3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        for (int i = 0; i < answers.length; ++i) {
            if (answers[i] == supo1[i % 5]) {
                ++m[0];
            }
            if (answers[i] == supo2[i % 8]) {
                ++m[1];
            }
            if (answers[i] == supo3[i % 10]) {
                ++m[2];
            }
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        int max = 0;
        for (int i = 0; i < 3; ++i) {
            if (m[i] > max) {
                list = new LinkedList<Integer>();
                list.add(i + 1);
                max = m[i];
            } else if (m[i] == max) {
                list.add(i + 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = list.get(i);
        }

        return res;
    }
}