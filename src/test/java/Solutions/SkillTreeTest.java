package Solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SkillTreeTest {

    @Test
    void solution1() {
        SkillTree instance = new SkillTree();

        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        assertThat(instance.solution1(skill, skillTrees)).isEqualTo(2);
    }

    @Test
    void removeExceptSkill() {
        SkillTree instance = new SkillTree();

        String skill_tree = "AECB";
        String skill = "CBD";

        assertThat(instance.removeExceptSkill(skill_tree, skill)).isEqualTo("CB");
    }

    @Test
    void solution2() {
        SkillTree instance = new SkillTree();

        String skill = "CBD";
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};

        assertThat(instance.solution2(skill, skillTrees)).isEqualTo(2);
    }
}
