package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrangeStringsTest {
    @Test
    void testcase1() {
        ArrangeStrings instance = new ArrangeStrings();
        String[] strings = {"sun", "bed", "car"};

        assertThat(instance.solution1(strings, 1)).containsExactly(new String[]{"car", "bed", "sun"});  // 순서까지 같아야함.
        assertThat(instance.solution1(strings, 1)).isEqualTo(new String[]{"car", "bed", "sun"});
    }

    @Test
    void testcase2() {
        ArrangeStrings instance = new ArrangeStrings();
        String[] strings = {"abce", "abcd", "cdx"};

        assertThat(instance.practice1(strings, 2)).containsExactly(new String[]{"abcd", "abce", "cdx"});
        assertThat(instance.practice1(strings, 2)).isEqualTo(new String[]{"abcd", "abce", "cdx"});
    }
}
