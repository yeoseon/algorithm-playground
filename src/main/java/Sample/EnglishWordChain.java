package Sample;

import java.util.HashSet;
import java.util.Set;

public class EnglishWordChain {
    public int[] solution(int n, String[] words) {

        int personNum = 1;
        int personOrder = 1;

        Set<String> passedWords = new HashSet<>();

        String beforeWord = words[0];

        for (int i = 1; i < words.length; i++) {
            String nextWord = words[i];
            passedWords.add(beforeWord);

            personNum = (personNum % n) + 1;

            if (i % n == 0) {
                personOrder++;
            }

            if (passedWords.contains(nextWord) || beforeWord.charAt(beforeWord.length() - 1) != nextWord.charAt(0)) {
                return new int[]{personNum, personOrder};
            }

            beforeWord = nextWord;
        }

        return new int[]{0, 0};
    }
}
