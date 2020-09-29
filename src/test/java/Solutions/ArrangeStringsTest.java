package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrangeStringsTest {
    @Test
    void testcase1() {
        ArrangeStrings instance = new ArrangeStrings();
        String[] strings = {"sun", "bed", "car"};

        assertThat(instance.solution(strings, 1)).containsExactly(new String[]{"car", "bed", "sun"});
        assertThat(instance.solution(strings, 1)).isEqualTo(new String[]{"car", "bed", "sun"});
    }

    @Test
    void testcase2() {
        ArrangeStrings instance = new ArrangeStrings();
        String[] strings = {"abce", "abcd", "cdx"};

        assertThat(instance.solution(strings, 2)).containsExactly(new String[]{"abcd", "abce", "cdx"});
        assertThat(instance.solution(strings, 2)).isEqualTo(new String[]{"abcd", "abce", "cdx"});
    }
}
