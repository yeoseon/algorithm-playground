package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameMapShortestDistanceTest {

    @Test
    void solution1() {
        int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};

        GameMapShortestDistance gameMapShortestDistance = new GameMapShortestDistance();
        assertThat(gameMapShortestDistance.solution2(maps1)).isEqualTo(11);
        assertThat(gameMapShortestDistance.solution1(maps2)).isEqualTo(-1);
    }
}
