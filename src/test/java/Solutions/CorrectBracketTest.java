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

        assertThat(instance.solution1(s1)).isTrue();
        assertThat(instance.solution1(s2)).isTrue();
        assertThat(instance.solution1(s3)).isFalse();
        assertThat(instance.solution1(s4)).isFalse();
    }
}
