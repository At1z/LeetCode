class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bans = new HashSet<>();
        for(int ban:banned){
            bans.add(ban);
        }
        int res = 0;
        for(int i = 1; i <= n; i++){
            if(bans.contains(i)){
                continue;
            }else{
                if(maxSum - i >= 0){
                    maxSum -= i;
                    res += 1;
                }else{
                    return res;
                }
            }
        }
        return res;
    }
}