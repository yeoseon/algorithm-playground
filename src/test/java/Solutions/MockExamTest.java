package Solutions;

import org.junit.jupiter.api.Test;

public class MockExamTest {

    @Test
    void solution() {
        int[] answers = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};
        MockExam mockExam = new MockExam();

        int[] result = mockExam.solution(answers2);
    }
}
