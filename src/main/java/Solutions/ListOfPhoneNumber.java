package Solutions;

public class ListOfPhoneNumber {

    /**
     * 1. 하나라도 접두어가 있는게 있으면 다음 절차를 수행하지 않고 False를 반환한다.
     * 2. 접두어 여부를 판단하는 방법
     *  2.1 두 단어를 비교해서, 한 단어의 길이만큼 모두 탐색할 때까지 같으면 false이다.
     *  2.2 순서가 고려되지 않는 2개의 조합이 필요하다. 2개로 정해져 있으므로 for문으로 돌리자.
     * @param phone_book
     * @return
     */
    public boolean solution1(String[] phone_book) {
        int count = 0;

        for(int i = 0; i < phone_book.length - 1; i++) {
            for(int j = i+1; j < phone_book.length; j++) {
                if(isPrefix(phone_book[i], phone_book[j])) {
                    count++;
                }
            }
        }

        return !(count > 0);
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
}
