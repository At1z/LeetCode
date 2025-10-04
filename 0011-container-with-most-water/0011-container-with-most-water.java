class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            int curL = height[l];
            int curR = height[r];
            res = Math.max(Math.min(curL,curR) * (r - l), res);
            // System.out.println(res);
            if(curL > curR){
                r -= 1;
            }else{
                l += 1;
            }
        }
        return res;
    }
}