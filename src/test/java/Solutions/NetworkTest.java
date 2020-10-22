package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NetworkTest {
    @Test
    void solution1() {
        Network instance = new Network();
        int n1 = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int n2 = 3;
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1,}, {0, 1, 1}};

        assertThat(instance.solution1(n1, computers1)).isEqualTo(2);
        assertThat(instance.solution1(n2, computers2)).isEqualTo(1);
    }
}
