package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TruckPassingBridgeTest {

    @Test
    void solution1() {
        TruckPassingBridge instance = new TruckPassingBridge();
        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = {7, 4, 5, 6};

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = {10};

        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        assertThat(instance.solution1(bridge_length1, weight1, truck_weights1)).isEqualTo(8);
        assertThat(instance.solution1(bridge_length2, weight2, truck_weights2)).isEqualTo(101);
//        assertThat(instance.solution1(bridge_length3, weight3, truck_weights3)).isEqualTo(110);
    }
}
