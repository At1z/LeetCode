class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        for (int i = 0; i < n1; i++) {
            int left = i, right = n2 - 1;
            int bestJ = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums2[mid] >= nums1[i]) {
                    bestJ = mid;      
                    left = mid + 1;   
                } else {
                    right = mid - 1; 
                }
            }

            if (bestJ != -1) {
                maxDist = Math.max(maxDist, bestJ - i);
            }
        }

        return maxDist;
    }
}
