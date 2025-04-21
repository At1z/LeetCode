class Solution {
    // 6 - 1 - (2 - (-2)) + 1 = 2
    // 5 - (-4) - ( 5 - (-1)) + 1 = 9 - 6 + 1 = 4
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int x = 0;
        int y = 0;
        int cur = 0;
        for (int d : differences) {
            cur += d;
            x = Math.min(x, cur);
            y = Math.max(y, cur);
            if (y - x > upper - lower) {
                return 0;
            }
        }
        return (upper - lower) - (y - x) + 1;
    }
}