package Solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NextBiggerNumberTest {

    @Test
    @DisplayName("n의 다음 큰 숫자를 반환한다.")
    void solution() {
        assertThat(NextBiggerNumber.solution(78)).isEqualTo(83);
        assertThat(NextBiggerNumber.solution(15)).isEqualTo(23);
    }
}
