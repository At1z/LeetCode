class Solution {
    public int maximumCount(int[] nums) {
        int pos = findfirstPositive(nums);
        int neg = findLastNegative(nums) + 1;
        return Math.max(neg, nums.length - pos);
    }
    private static int findLastNegative(int[] arr) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < 0) {
                result = mid;  
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    private static int findfirstPositive(int[] arr) {
        int left = 0, right = arr.length - 1, result = arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > 0) {
                result = mid;  
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}