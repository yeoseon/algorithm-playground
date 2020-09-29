package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KthNumberTest {
    @Test
    void solution1Test() {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        assertThat(KthNumber.solution1(array, commands)).isEqualTo(new int[]{5, 6, 3});
    }

    @Test
    void solution2Test() {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        assertThat(KthNumber.solution2(array, commands)).isEqualTo(new int[]{5, 6, 3});
    }
}
