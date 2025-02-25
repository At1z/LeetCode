class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(amount);
        set.add(amount);
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            step += 1;
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                for(int coin : coins){
                    int next = cur - coin;
                    if(next == 0){
                        return step;
                    }else if(next > 0 && !set.contains(next)){
                        q.add(next);
                        set.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
