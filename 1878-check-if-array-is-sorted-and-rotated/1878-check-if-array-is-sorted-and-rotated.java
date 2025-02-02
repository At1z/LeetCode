class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (isSorted(nums)) {
                return true;
            }
            rotate(nums);
        }
        return false;
    }
    
    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return true;
    }
    
    private void rotate(int[] nums) {
        int first = nums[0];
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[n - 1] = first;
    }
}