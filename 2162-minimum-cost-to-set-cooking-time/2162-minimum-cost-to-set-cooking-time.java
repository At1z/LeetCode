class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minutes = targetSeconds / 60;
        int seconds = targetSeconds % 60;
        int minCost = Integer.MAX_VALUE;  
        
        if (minutes < 100) {
            String time1 = String.format("%02d%02d", minutes, seconds).replaceFirst("^0+(?!$)", "");
            minCost = Math.min(minCost, calculateCost(time1, startAt, moveCost, pushCost));
        }
        if (minutes > 0 && seconds + 60 < 100) {
            String time2 = String.format("%02d%02d", minutes - 1, seconds + 60).replaceFirst("^0+(?!$)", "");
            minCost = Math.min(minCost, calculateCost(time2, startAt, moveCost, pushCost));
        }
        
        return minCost;
    }
        public int calculateCost(String time, int startAt, int moveCost, int pushCost) {
            int res = 0;
            int currentPosition = startAt;
            for (char c : time.toCharArray()) {
                int digit = c - '0';
                if (digit != currentPosition) {
                    res += moveCost;
                    currentPosition = digit; 
                }
                res += pushCost;
            }
            return res;  
        }
}
