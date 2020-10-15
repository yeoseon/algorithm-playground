package Solutions;

public class ListOfPhoneNumber {

    /**
     * 시간 복잡도 : 만약 마지막요소와 마지막 - 1 요소에서 접두어가 나온다면, 결국은 모두 돌게 된다.
     * 이때 시간 복잡도는..
     *
     * 1. 하나라도 접두어가 있는게 있으면 다음 절차를 수행하지 않고 False를 반환한다.
     * 2. 접두어 여부를 판단하는 방법
     *  2.1 두 단어를 비교해서, 한 단어의 길이만큼 모두 탐색할 때까지 같으면 false이다.
     *  2.2 순서가 고려되지 않는 2개의 조합이 필요하다. 2개로 정해져 있으므로 for문으로 돌리자.
     * @param phone_book
     * @return
     */
    public boolean solution1(String[] phone_book) {
        for(int i = 0; i < phone_book.length - 1; i++) {
            for(int j = i+1; j < phone_book.length; j++) {
                if(isPrefix(phone_book[i], phone_book[j])) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isPrefix(String string1, String string2) {
        int index = 0;

        while(index < string1.length() && index < string2.length()) {

            if(string1.charAt(index) != string2.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    /**
     * startwith라는 API를 사용하여 푼다.
     * 하지만 이 방법도 위의 나의 풀이와 같이 하나하나씩 모두 검사한다고 한다.
     * https://codevang.tistory.com/290
     * @param phone_book
     * @return
     */
    public boolean solution2(String[] phone_book) {
        for(int i = 0; i < phone_book.length -1; i++) {
            for(int j = i+1; j < phone_book.length; j++) {
                if(phone_book[i].startsWith(phone_book[j])) {return false;}
                if(phone_book[j].startsWith(phone_book[i])) {return false;}
            }
        }
        return true;
    }

    /**
     * 문자열을 비교하는 방법 중 가장 빠른 방법이 '해시'이다.
     *
     * 문자열을 하나의 해시코드 숫자로 만든 뒤 두 숫자를 비교한다.
     *
     * https://codevang.tistory.com/290
     * @param phone_book
     * @return
     */
    public boolean solution3(String[] phone_book) {
        for(int i = 0 ; i < phone_book.length - 1; i++) {
            int hashcode = phone_book[i].hashCode();
            int len = phone_book[i].length();

            for(int j = i+1; j < phone_book.length; j++) {
                if(phone_book[j].length() >= len && phone_book[j].substring(0, len).hashCode() == hashcode) {
                    return false;
                }
                else if(phone_book[j].length() < len && phone_book[i].substring(0, phone_book[j].length()).hashCode() == phone_book[j].hashCode()) {
                    return false;
                }
            }
        }

        return true;
    }
}
