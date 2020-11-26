package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tiling3xnTest {

    @Test
    void solution1() {
        Tiling3xn tiling3xn = new Tiling3xn();

        assertThat(tiling3xn.solution1(4)).isEqualTo(11);
    }
}
