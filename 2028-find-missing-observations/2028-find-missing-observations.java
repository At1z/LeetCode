class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (m + n);
        int missingSum = totalSum - sum(rolls);

        if (missingSum > 6 * n || missingSum < n) {
            return new int[0];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int dice = Math.min(6, missingSum - (n - i - 1));
            res[i] = dice;
            missingSum -= dice;
        }

        return res;
    }

    private int sum(int[] rolls) {
        int total = 0;
        for (int roll : rolls) {
            total += roll;
        }
        return total;
    }
}
