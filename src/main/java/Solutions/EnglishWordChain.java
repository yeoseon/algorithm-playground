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

        public String sayWord() {
            order++;
            return words[order - 1];
        }

        public String[] getWords() {
            return words;
        }

        public int getOrder() {
            return this.order;
        }
    }

    public class WordChainGame {
        private int playerCount;        // 게임 참여 Player 수
        private String[] words;         // 전체 단어
        private List<Player> players;
        private List<String> wordHistory;   // 제시한 단어 History;

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

        private String[] pickPlayerWords(int playerCount, int playerNumber, String[] entireWords) {
            List<String> words = new ArrayList<>();

            // TODO: 더 효율적으로 바꿀 수 있을 것 같다. (Stream을 이용할 수 있을 것 같다.)
            // TODO: While을 이용해도 될 거 같다.
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

        public void play() {

            while(true) {

            }
        }

        //TODO: Player로부터 와야한다. Play 함수 추가 필요
        public void addWordHistory(String word) {
            if(isCorrectWord(word)) {
                wordHistory.add(word);
            }
        }

        //TODO: 테스트용 Correct 판별 메소드
        public boolean isCorrectWordTest(List<String> wordHistory, String word) {

            // 1. 끝말잇기 룰에 부합하는 지 검사
            String tailCharacter = getTailCharacter(wordHistory);
            if(!tailCharacter.equals(word.substring(0, 1))) {
                return false;
            }
            // 2. 중복되는 단어가 불려졌는 지 검사
            if(wordHistory.contains(word)) {
                return false;
            }

            return true;
        }

        private boolean isCorrectWord(String word) {
            // 1. 끝말잇기 룰에 부합하는 지 검사
            String tailCharacter = getTailCharacter(wordHistory);
            if(!tailCharacter.equals(word.substring(0, 1))) {
                return false;
            }

            // 2. 중복되는 단어가 불려졌는 지 검사
            if(wordHistory.contains(word)) {
                return false;
            }

            return true;
        }

        private String getTailCharacter(List<String> wordHistory) {
            String lastWord = wordHistory.get(wordHistory.size() - 1);

            return lastWord.substring(lastWord.length() - 1);
        }

        public List<Player> getPlayers() {
            return players;
        }

        //TODO: Players라는 객체로 관리해도 되겠다.
        public Player getPlayer(int number) {
            return players.get(number - 1);
        }
    }
}
