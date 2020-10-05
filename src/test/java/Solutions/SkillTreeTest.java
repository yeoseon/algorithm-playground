package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SkillTreeTest {

    @Test
    void solution1() {
        SkillTree instance = new SkillTree();

        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        assertThat(instance.solution(skill, skillTrees)).isEqualTo(2);
    }
}
