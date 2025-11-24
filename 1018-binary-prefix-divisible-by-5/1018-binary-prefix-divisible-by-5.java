class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int cur = 0;

        for (int bit : nums) {
            cur = (cur * 2 + bit) % 5;
            res.add(cur == 0);
        }

        return res;
    }
}

// 1 0 1 = 4 + 1 = 5
// 1 0 1 0 = 8 + 2 = 10
// 1 0 1 1 = 5 * 2 + 1 = 11
// 1 0 1 1 0 = 16 + 4 + 2 = 22 
// 1 0 1 1 0 1 = 32 + 8 + 4 + 1 = 45
// ==============
// 1 = 1
// 1 1 = 3
// 1 1 1 = 7
// 1 1 1 0 = 8 + 4 + 2 = 14
// 1 1 1 0 1 = 16 + 8 + 4 + 1 = 29
