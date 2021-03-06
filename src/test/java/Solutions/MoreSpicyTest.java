package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoreSpicyTest {
    @Test
    void solution1Test() {
        MoreSpicy moreSpicy = new MoreSpicy();
        final int[] scoville = { 1, 2, 3, 9, 10, 12 };

        assertThat(moreSpicy.solution1(scoville, 7)).isEqualTo(2);
    }

    @Test
    void solution2Test() {
        MoreSpicy moreSpicy = new MoreSpicy();
        final int[] scoville = { 1, 2, 3, 9, 10, 12 };

        assertThat(moreSpicy.solution2(scoville, 7)).isEqualTo(2);
    }
}
