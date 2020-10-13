package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CamouflageTest {

    @Test
    void solution1() {
        Camouflage instance = new Camouflage();
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        assertThat(instance.solution1(clothes1)).isEqualTo(5);
        assertThat(instance.solution1(clothes2)).isEqualTo(3);
    }
}
