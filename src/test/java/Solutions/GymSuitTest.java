package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GymSuitTest {

    @Test
    void solution1() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve1 = {1, 3, 5};
        int[] reserve2 = {3};

        GymSuit gymSuit = new GymSuit();

        assertThat(gymSuit.solution1(n, lost, reserve1)).isEqualTo(5);
        assertThat(gymSuit.solution1(n, lost, reserve2)).isEqualTo(4);
    }
}
