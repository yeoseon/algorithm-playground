package Main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
    @Test
    @DisplayName("메인 메소드 테스트")
    public void printTest() {
        Helloworld.print();
    }
}
