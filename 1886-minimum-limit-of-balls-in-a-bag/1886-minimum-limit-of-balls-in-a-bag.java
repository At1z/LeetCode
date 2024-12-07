class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;  
            
            if (canDivide(mid, nums, maxOperations)) {
                right = mid;  
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean canDivide(int maxSize, int[] nums, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            if (num > maxSize) {
                operations += (num - 1) / maxSize;
            }
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}