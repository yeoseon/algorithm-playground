package Solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MakingPrimeNumberTest {

    @Test
    void solutionTest1() {
        MakingPrimeNumber instance = new MakingPrimeNumber();
        int[] nums = new int[]{1, 2, 3, 4};

        assertThat(instance.solution1(nums)).isEqualTo(1);
    }

    @Test
    void solutionTest2() {
        MakingPrimeNumber instance = new MakingPrimeNumber();
        int[] nums = new int[]{1, 2, 7, 6, 4};

        assertThat(instance.solution1(nums)).isEqualTo(4);
    }

    @Test
    @DisplayName("소수인지 판별한다.")
    void isPrimeNumber() {
        MakingPrimeNumber instance = new MakingPrimeNumber();

        //TODO: assertJ를 이용해 더 편리하게 Refactoring 한다.
        assertThat(instance.isPrimeNumber1(0)).isFalse();
        assertThat(instance.isPrimeNumber1(1)).isFalse();
        assertThat(instance.isPrimeNumber1(2)).isTrue();
        assertThat(instance.isPrimeNumber1(10)).isFalse();
        assertThat(instance.isPrimeNumber1(13)).isTrue();

        assertThat(instance.isPrimeNumber2(0)).isFalse();
        assertThat(instance.isPrimeNumber2(1)).isFalse();
        assertThat(instance.isPrimeNumber2(2)).isTrue();
        assertThat(instance.isPrimeNumber2(10)).isFalse();
        assertThat(instance.isPrimeNumber2(13)).isTrue();

        assertThat(instance.isPrimeNumber3(0)).isFalse();
        assertThat(instance.isPrimeNumber3(1)).isFalse();
        assertThat(instance.isPrimeNumber3(2)).isTrue();
        assertThat(instance.isPrimeNumber3(10)).isFalse();
        assertThat(instance.isPrimeNumber3(13)).isTrue();
    }
}
