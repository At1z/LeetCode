class Solution {
    public long countGood(int[] nums, int k) {
        long l = 0;
        Map<Integer, Integer> currentFreq = new HashMap<>();
        int pairs = 0;
        long res = 0;
        long r = 0;

        while (r < nums.length) {
            int num = nums[(int) r];
            currentFreq.put(num, currentFreq.getOrDefault(num, 0) + 1);

            if (currentFreq.get(num) >= 2) {
                pairs += currentFreq.get(num) - 1;
            }

            while (pairs >= k) {
                res += nums.length - (int) r;

                int leftNum = nums[(int) l];
                int count = currentFreq.get(leftNum);
                pairs -= count - 1;
                currentFreq.put(leftNum, count - 1);
                l++;
            }

            r++;
        }

        return res;
    }
}
