package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordConversionTest {

    @Test
    void solution1() {
        String begin = "hit";
        String target = "cog";
        String[] word1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] word2 = {"hot", "dot", "dog", "lot", "log"};

        WordConversion wordConversion = new WordConversion();
        assertThat(wordConversion.solution1(begin, target, word1)).isEqualTo(4);
        assertThat(wordConversion.solution1(begin, target, word2)).isEqualTo(0);
    }
}
