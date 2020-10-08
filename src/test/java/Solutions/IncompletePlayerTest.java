package Solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IncompletePlayerTest {
    @Test
    @DisplayName("완주하지 못한 선수")
    void solutionTest1() {
        IncompletePlayer instance = new IncompletePlayer();

        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        assertThat(instance.solution3(participant, completion)).isEqualTo("vinko");
    }

    @Test
    @DisplayName("완주하지 못한 선수")
    void solutionTest2() {
        IncompletePlayer instance = new IncompletePlayer();

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        assertThat(instance.solution3(participant, completion)).isEqualTo("leo");
    }

    @Test
    @DisplayName("완주하지 못한 선수")
    void solutionTest3() {
        IncompletePlayer instance = new IncompletePlayer();

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        assertThat(instance.solution3(participant, completion)).isEqualTo("mislav");
    }
}
