package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CorrectBracketTest {

    @Test
    void solution1() {
        CorrectBracket instance = new CorrectBracket();
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";
        String s5 = "(()))((())";       // 내가 추가한 테스트케이스. 숫자가 갖다고 해도 성립이 안될 수 있음

        assertThat(instance.solution2(s1)).isTrue();
        assertThat(instance.solution2(s2)).isTrue();
        assertThat(instance.solution2(s3)).isFalse();
        assertThat(instance.solution2(s4)).isFalse();
        assertThat(instance.solution2(s5)).isFalse();
    }
}
