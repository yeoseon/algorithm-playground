package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LengthOfVisitTest {

    @Test
    void solution() {
        LengthOfVisit instance = new LengthOfVisit();
        assertThat(instance.solution("ULURRDLLU")).isEqualTo(7);
        assertThat(instance.solution("LULLLLLLU")).isEqualTo(7);
    }
}
