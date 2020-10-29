package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RamenFactoryTest {

    @Test
    void solution1() {
        RamenFactory instance = new RamenFactory();

        int stock = 4;
        int[] dates = {4, 10, 5};
        int[] supplies = {20, 5, 10};
        int k = 30;

        assertThat(instance.solution1(stock, dates, supplies, k)).isEqualTo(2);
    }
}
