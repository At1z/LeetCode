class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        return (zeroArrayBuilder(nums, queries))?true:false;
    }

    public boolean zeroArrayBuilder(int[] nums, int[][] queries){
        int sum = 0;
        int[] diffArray = new int[nums.length + 1];

        for(int query = 0; query < queries.length; query++){
            int l = queries[query][0];
            int r = queries[query][1];

            diffArray[l] += 1;
            diffArray[r + 1] -= 1;
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