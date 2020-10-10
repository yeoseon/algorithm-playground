package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceOfStockTest {
    @Test
    void solution() {
        PriceOfStock instance = new PriceOfStock();
        int[] prices = {1, 2, 3, 2, 3};

        assertThat(instance.solution1(prices)).containsExactly(4, 3, 1, 1, 0);
    }
}
