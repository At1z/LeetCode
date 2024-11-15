class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        while (left < size - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == size - 1) {
            return 0;
        }
        int res = Math.min(size - left - 1, right);
        int l = 0, r = right;
        while (l <= left && r < size) {
            if (arr[l] <= arr[r]) {
                res = Math.min(res, r - l - 1);
                l++;
            } else {
                r++;
            }
        }
        return res;
    }
}
