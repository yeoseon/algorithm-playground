package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeTest {

    @Test
    void solution1() {
        int n = 5;
        int l = 4;
        String arr[] = {"AA", "BB", "BC", "CB"};
        Palindrome palindrome = new Palindrome();

        assertThat(palindrome.solution1(n, l, arr)).isEqualTo(9);
    }
}
