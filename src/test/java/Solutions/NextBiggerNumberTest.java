package Solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NextBiggerNumberTest {

    @Test
    @DisplayName("n의 다음 큰 숫자를 반환한다.")
    void solution1() {
        assertThat(NextBiggerNumber.solution1(78)).isEqualTo(83);
        assertThat(NextBiggerNumber.solution1(15)).isEqualTo(23);
    }

    @Test
    @DisplayName("n의 다음 큰 숫자를 반환한다.")
    void solution2() {
        assertThat(NextBiggerNumber.solution2(78)).isEqualTo(83);
        assertThat(NextBiggerNumber.solution2(15)).isEqualTo(23);
    }

    @Test
    @DisplayName("n의 다음 큰 숫자를 반환한다.")
    void solution3() {
        assertThat(NextBiggerNumber.solution3(78)).isEqualTo(83);
        assertThat(NextBiggerNumber.solution3(15)).isEqualTo(23);
    }
}
