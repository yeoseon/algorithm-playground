package Solutions;

import java.util.Arrays;
import java.util.Comparator;

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

    /**
     * 풀이 중에 Comparator을 사용하는 방법도 있음
     * compare을 재구현 하여 구하는 방법
     * Arrays.sort 메서드를 잘 알고 활용한 풀이
     * 속도가 10배 이상 빠르다
     * @param strings
     * @param n
     * @return
     */
    public String[] solution2(String[] strings, int n) {
        Arrays.sort(strings, (String s, String t1) -> {
            char c1 = s.charAt(n);
            char c2 = t1.charAt(n);

            if(c1 == c2) {
                return s.compareTo(t1);
            }
            else {
                return c1 - c2;     // -1, 0, 1
            }
        });

        return strings;
    }
}
