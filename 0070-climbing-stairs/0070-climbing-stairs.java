class Solution {
    public int climbStairs(int n) {
        int []array = new int [45];
       array[0] = 1;
       array[1] = 2;
       for(int i = 2; i < n; i++){
           array[i] = array[i-1] + array[i-2];
           System.out.println(array[i]);
       }
       return array[n - 1];
    }
}