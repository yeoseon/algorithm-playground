package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetNumberTest {

    @Test
    void solution1() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        TargetNumber targetNumber = new TargetNumber();
        assertThat(targetNumber.solution1(numbers, target)).isEqualTo(5);
    }
}
