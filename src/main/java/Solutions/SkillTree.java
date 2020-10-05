package Solutions;

import java.util.ArrayList;
import java.util.List;

public class SkillTree {

    /**
     * 1. 주어진 배열을 for문으로 돌려 검사한다.
     * 2. 검사 조건
     *  - 입력받은 skill의 순서가 맞아야 한다.
     *  - 중간에 입력받은 skill 외 skill이 있어도 된다.
     *  - 입력받은 skill이 모두 있지 않아도 된다. 아예 없어도 된다.
     * 3. 구현 방법
     *  - 1) 중간에 입력받은 skill 외 skill은 모두 신경쓰지 않기 때문에 모두 제외한다.
     *  - 2) 남은 것이 없는 경우 True 이다.
     *  - 3) 남은 것이 있는 경우
     *      - 3-2) 입력받은 수를 차례대로 비교해서 다른 경우 False, 같은 경우 True (끝까지 가지 않아도 순서만 같으면 됨)
     * 4. 그 외 고민
     *  - 입력받은 skill로 순서대로 구성하는 경우의 수를 담아서 만들고, 위의 3의 1) 후에 포함되는지 여부만 판단하면 되지 않을까 싶다.
     * @param skill
     * @param skill_trees
     * @return
     */
    public int solution1(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i = 0; i < skill_trees.length; i++) {
            if(isPossibleSkillTree(removeExceptSkill(skill_trees[i], skill), skill)) {
                answer++;
            }
        }
        return answer;
    }

    /**
     * 입력받은 Skill 외 Skill 삭제
     * @param skill_tree
     * @param skill
     * @return
     */
    public String removeExceptSkill(String skill_tree, String skill) {
        List<String> removeTargets = new ArrayList<>();

        for(int i = 0; i < skill_tree.length(); i++) {
            int count = 0;

            for(int j = 0; j < skill.length(); j++) {
                if(skill_tree.charAt(i) == skill.charAt(j)) {
                    count++;
                }
            }

            if(count <= 0) {
                removeTargets.add(Character.toString(skill_tree.charAt(i)));
            }
        }

        // skill_tree.charAt(i)를 remove한다.
        for(String removeTarget : removeTargets) {
            skill_tree = skill_tree.replaceAll(removeTarget, "");
        }

        return skill_tree;
    }

    /**
     * 가능한 스킬트리인지 검사
     * @param skill_tree
     * @param skill
     * @return
     */
    private boolean isPossibleSkillTree(String skill_tree, String skill) {
        if(skill.length() == 0) {
            return true;
        }

        for(int i = 0; i < skill_tree.length(); i++) {
            if(skill_tree.charAt(i) != skill.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 필요없는 스킬은 삭제하는 방법은 같으나, toString 대신에 valudOf라는 정적 팩토리를 사용하도록 하고, indexOf와 contains 등의 API를 잘 활용해서 좀 더 간략하게 구현한다.
     * @param skill
     * @param skill_trees
     * @return
     */
    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i = 0; i < skill_trees.length; i++) {
            String skill_tree = skill_trees[i];
            String skill_tree_clone = new String(skill_tree);       // 답을 구하기 위한 값은 clone 값을 사용할 것이다.

            for(int j = 0; j < skill_tree.length(); j++) {
                String oneSkill = String.valueOf(skill_tree.charAt(j));

                if(!skill.contains(oneSkill)) {
                    skill_tree_clone = skill_tree_clone.replace(oneSkill, "");
                }
            }

            if(skill.indexOf(skill_tree_clone) == 0) {      // ABCDE에 ABC가 있다면 0이 나올 것이다.
                answer++;
            }
        }
        return answer;
    }
}
