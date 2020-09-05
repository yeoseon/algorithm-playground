package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnglishWordChainTest {

    @Test
    void solution1() {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        assertThat(EnglishWordChain.solution(n, words)).containsExactly(3, 3);
    }

    @Test
    void solution2() {
        int n = 5;
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

        assertThat(EnglishWordChain.solution(n, words)).containsExactly(0, 0);
    }

    @Test
    void solution3() {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

        assertThat(EnglishWordChain.solution(n, words)).containsExactly(1, 3);
    }
}
