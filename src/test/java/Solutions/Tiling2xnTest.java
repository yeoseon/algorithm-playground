package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tiling2xnTest {

    @Test
    void solution1() {
        Tiling2xn tiling2xn = new Tiling2xn();

        int n = 4;

        assertThat(tiling2xn.solution1(n)).isEqualTo(5);
    }
}
