package Solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RamenFactoryTest {

    @Test
    void solution1() {
        RamenFactory instance = new RamenFactory();

        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;

        assertThat(instance.solution1(stock, dates, supplies, k)).isEqualTo(2);
    }

    @Test
    @DisplayName("최소 횟수로 받아와야 하는 케이스")
    void solution1_case2() {
        RamenFactory ramenFactory = new RamenFactory();

        int stock  = 4;
        int[] dates = {4, 10, 11, 15};
        int[] supplies = {20, 3, 3, 10};        // 3, 3을 두번 받아도 되긴 하지만, 최소를 구해야 한다.
        int k = 30;

        assertThat(ramenFactory.solution1(stock, dates, supplies, k)).isEqualTo(2);
    }
}
