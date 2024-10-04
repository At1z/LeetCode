class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long temp = skill[0] + skill[skill.length-1];
        long res = skill[0] * skill[skill.length-1];
        for(int i = 1; i < skill.length/2; i++){
            if(temp == skill[i] + skill[skill.length-1-i]){
                res += skill[i] * skill[skill.length-1-i];
            }else{
                return -1;
            }
        }
        return res;
    }
}