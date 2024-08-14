class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int left = 0;

            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
//
//    public int smallestDistancePair(int[] nums, int k) {
//        Arrays.sort(nums);
//      int[] smallestDistance = new int[k];
//      for(int i = 0; i < k; i++){
//            smallestDistance[i]=nums[nums.length-1];
//        }
//
//        for(int i = 0; i < nums.length-1; i++){
//            for (int j = i+1; j < nums.length; j++){
//                int ans = Math.abs(nums[i] - nums[j]);
//                arr(smallestDistance, ans);
//            }
//        }
//    return smallestDistance[k-1];
//    }
//
//   public int[] arr(int[] smallestDistance2, int ans2) {
//    int i = 0;
//    while (i < smallestDistance2.length && ans2 > smallestDistance2[i]) {
//        i++;
//    }
//    while (i < smallestDistance2.length) {
//        int temp = smallestDistance2[i];
//        smallestDistance2[i] = ans2;
//        ans2 = temp;
//        i++;
//    }
//   return smallestDistance2;
//    }
