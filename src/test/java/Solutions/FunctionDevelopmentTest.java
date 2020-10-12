package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionDevelopmentTest {

    @Test
    void solution1() {
        FunctionDevelopment instance = new FunctionDevelopment();
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        int[] progresses3 = {95, 90, 99, 99, 80, 99};
        int[] speeds3 = {10, 10, 10, 10, 10, 10};

        assertThat(instance.solution1(progresses1, speeds1)).containsExactly(2, 1);
        assertThat(instance.solution1(progresses2, speeds2)).containsExactly(1, 3, 2);
        assertThat(instance.solution1(progresses3, speeds3)).containsExactly(4, 2);
    }
}
