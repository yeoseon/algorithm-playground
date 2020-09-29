package Solutions;

import java.util.Arrays;

public class ArrangeStrings {

    /**
     * 비교하고자 하는 대상과 정렬하고자 하는 대상이 다름..
     * 비교하고자 하는 대상을 기존 string 맨 앞에 붙혀서 정렬 후, 마지막에 제거해주는 방법
     * @param strings
     * @param n
     * @return
     */
    public String[] solution1(String[] strings, int n) {
        String[] copyStrings = new String[strings.length];

        for(int i = 0; i < strings.length; i++) {
            copyStrings[i] = strings[i].charAt(n) + strings[i];
        }

        Arrays.sort(copyStrings);

        for(int i = 0; i < copyStrings.length; i++) {
            copyStrings[i] = copyStrings[i].substring(1, copyStrings[i].length());
        }
        return copyStrings;
    }
}
