package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThieveryTest {

    @Test
    void solution1() {
        Thievery thievery = new Thievery();
        int[] money = {1, 2, 3, 1};

        assertThat(thievery.solution1(money)).isEqualTo(4);
    }
}
