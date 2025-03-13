class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int l = 0;
        int r = queries.length;
        if(!zeroArrayFound(nums, queries, r)){
            return -1;   
        }
        while(l <= r){
            int mid = l + (r-l)/2;
            if(zeroArrayFound(nums, queries, mid)){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    public boolean zeroArrayFound(int[] nums, int[][] queries, int mid){
        int sum = 0;
        int[] diffArray = new int[nums.length + 1];

        for(int query = 0; query < mid; query++){
            int l = queries[query][0];
            int r = queries[query][1];
            int val = queries[query][2];

            diffArray[l] += val;
            diffArray[r + 1] -= val;  
        } 

        for(int index = 0; index < nums.length; index++){
            sum += diffArray[index];
            if(sum < nums[index]){
                return false;
            }
        }
        return true;
    }
}