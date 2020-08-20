package Solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IncompletePlayerTest {
    @Test
    @DisplayName("완주하지 못한 선수")
    void solutionTest() {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        IncompletePlayer.solution(participant, completion);
    }
}
