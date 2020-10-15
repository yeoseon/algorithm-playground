package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListOfPhoneNumberTest {
    @Test
    void solution1() {
        ListOfPhoneNumber instance = new ListOfPhoneNumber();

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};

        assertThat(instance.solution1(phone_book1)).isFalse();
        assertThat(instance.solution1(phone_book2)).isTrue();
        assertThat(instance.solution1(phone_book3)).isFalse();
    }

    @Test
    void solution2() {
        ListOfPhoneNumber instance = new ListOfPhoneNumber();

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};

        assertThat(instance.solution2(phone_book1)).isFalse();
        assertThat(instance.solution2(phone_book2)).isTrue();
        assertThat(instance.solution2(phone_book3)).isFalse();
    }

    @Test
    void solution3() {
        ListOfPhoneNumber instance = new ListOfPhoneNumber();

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};

        assertThat(instance.solution3(phone_book1)).isFalse();
        assertThat(instance.solution3(phone_book2)).isTrue();
        assertThat(instance.solution3(phone_book3)).isFalse();
    }
}
