package Solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashedNumberTest {

    @Test
    @DisplayName("숫자를 입력받아 해당 숫자가 하샤드 수인지 여부를 리턴한다.")
    void solutionTest1() {
        int x1 = 10;
        int x2 = 12;
        int x3 = 11;
        int x4 = 13;
        assertThat(HashedNumber.solution(x1)).isTrue();
        assertThat(HashedNumber.solution(x2)).isTrue();
        assertThat(HashedNumber.solution(x3)).isFalse();
        assertThat(HashedNumber.solution(x4)).isFalse();
    }
}
