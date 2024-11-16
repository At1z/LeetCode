class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] subA = new int[n - k + 1];
        Arrays.fill(subA,-1);
        for(int i = n-1; i > k-2; i--){
            boolean consecutive = true;
            for(int j = i; j > i - (k - 1); j--){
                if((nums[j] - 1) != nums[j-1]){
                    consecutive = false;
                    break;
                }
            }
            if(consecutive){
                subA[i-k+1] = nums[i];
            }
        }
        return subA;
    }
}