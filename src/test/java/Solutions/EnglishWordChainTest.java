package Solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EnglishWordChainTest {

    EnglishWordChain instance = new EnglishWordChain();

    @Test
    void solution1() {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        assertThat(instance.solution(n, words)).containsExactly(3, 3);
    }

    @Test
    void solution2() {
        int n = 5;
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

        assertThat(instance.solution(n, words)).containsExactly(0, 0);
    }

    @Test
    void solution3() {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

        assertThat(instance.solution(n, words)).containsExactly(1, 3);
    }

    @Test
    @DisplayName("게임을 생성할 시, 플레이어의 단어 목록이 잘 Assign 되는지 확인한다.")
    void WordChainGame() {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        EnglishWordChain.WordChainGame game = instance.makeGame(n, words);
        List<EnglishWordChain.Player> players = game.getPlayers();

        assertThat(players.get(0).getWords()).containsExactly("tank", "wheel", "mother");
        assertThat(players.get(1).getWords()).containsExactly("kick", "land", "robot");
        assertThat(players.get(2).getWords()).containsExactly("know", "dream", "tank");
    }
}
