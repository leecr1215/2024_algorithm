function solution(skill, skill_trees) {
    
    skill_trees = skill_trees.map((skill_tree) => skill_tree.split("").filter((alpha)=>skill.includes(alpha)).join("")
    ).filter((skill_tree) => skill.startsWith(skill_tree));
    
    
    return skill_trees.length;
}