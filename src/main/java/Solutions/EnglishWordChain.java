package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 영어 끝말잇기
 * https://school.programmers.co.kr/courses/10586/lessons/67680
 */
public class EnglishWordChain {

    /**
     * [탈락의 경우]
     * 1. 끝말잇기의 규칙에 어긋나는 경우 (끝 문자로 시작하는 단어를 말하지 않은 경우)
     * 2. 중복되는 단어를 말한 경우
     *
     * [구현 방법 구상]
     * 1. Player 라는 객체를 가진다.
     * - 가지고 있는 단어 목록과, 순서, player number 정보를 갖는다.
     * 3. 끝말잇기 게임 객체도 하나 가진다.
     * - 단어가 적합한지 여부를 판단한다.
     * - 이를 위해 끝글자 및 history도 관리해야 한다.
     */
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        WordChainGame game = new WordChainGame(n, words);
        return answer;
    }

    public WordChainGame makeGame(int n, String[] words) {
        return new WordChainGame(n, words);
    }

    public class Player {
        private int number;         // Player Number (start with 1)
        private String[] words;     // 가진 단어들
        private int order;          // 단어 제시 순서

        public Player(int number, String[] words) {
            this.number = number;
            this.words = words;
            this.order = 0;
        }

        public String[] getWords() {
            return words;
        }
    }

    public class WordChainGame {
        private int playerCount;        // 게임 참여 Player 수
        private String[] words;         // 전체 단어
        private List<Player> players;

        public WordChainGame(int playerCount, String[] words) {
            this.playerCount = playerCount;
            this.words = words;
            this.players = assignPlayers();
        }

        private List<Player> assignPlayers() {
            List<Player> players = new ArrayList<>();

            for(int i = 1; i <= playerCount; i++) {
                players.add(new Player(i, pickPlayerWords(this.playerCount, i, this.words)));
            }

            return players;
        }

        // TODO: 더 효율적으로 바꿀 수 있을 것 같다. (Stream을 이용할 수 있을 것 같다.)
        private String[] pickPlayerWords(int playerCount, int playerNumber, String[] entireWords) {
            List<String> words = new ArrayList<>();

            for(int i = 0; i < entireWords.length; i++) {
                if(playerCount == playerNumber) {
                    if((i+1) % playerCount == 0) {
                        words.add(entireWords[i]);
                    }
                }
                else if((i+1) % playerCount == playerNumber) {
                    words.add(entireWords[i]);
                }
            }

            return words.stream()
                    .toArray(String[]::new);
        }

        public List<Player> getPlayers() {
            return players;
        }
    }
}
