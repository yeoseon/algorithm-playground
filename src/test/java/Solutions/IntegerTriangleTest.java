package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerTriangleTest {

    @Test
    void solution1() {
        IntegerTriangle instance = new IntegerTriangle();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        assertThat(instance.solution1(triangle)).isEqualTo(30);
    }
}
