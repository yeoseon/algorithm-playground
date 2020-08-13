import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.*;

public class HashedNumberTest {

    @Test
    @DisplayName("숫자를 입력받아 해당 숫자가 하샤드 수인지 여부를 리턴한다.")
    void solutionTest1() {
        int x1 = 10;
        int x2 = 12;
        int x3 = 11;
        int x4 = 13;
        HashedNumber.solution(x1);
        HashedNumber.solution(x2);
        HashedNumber.solution(x3);
        HashedNumber.solution(x4);
    }
}
