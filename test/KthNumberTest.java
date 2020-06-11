import org.junit.jupiter.api.Test;

public class KthNumberTest {
    @Test
    void solutionTest() {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};

        int[] result = KthNumber.solution(array, commands);
//        assertThat(KthNumber.solution(array, commands)).isEqual(new int[]{5, 6, 3});
    }
}
