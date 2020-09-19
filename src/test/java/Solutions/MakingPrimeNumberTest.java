package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MakingPrimeNumberTest {

    @Test
    void solutionTest1() {
        MakingPrimeNumber instance = new MakingPrimeNumber();
        int[] nums = new int[]{1, 2, 3, 4};

        assertThat(instance.solution(nums)).isEqualTo(1);
    }

    @Test
    void solutionTest2() {
        MakingPrimeNumber instance = new MakingPrimeNumber();
        int[] nums = new int[]{1, 2, 7, 6, 4};

        assertThat(instance.solution(nums)).isEqualTo(4);
    }
}
