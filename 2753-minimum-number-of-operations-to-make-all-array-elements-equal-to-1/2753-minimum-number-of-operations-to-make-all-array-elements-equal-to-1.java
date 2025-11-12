class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        int modulos = 0;
        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
            modulos = gcd(modulos, num);
        }
        if (ones > 0) {
            return n - ones;
        }
        if (modulos > 1) {
            return -1;
        }
        int minLen = n;
        for (int i = 0; i < n; i++) {
            int currentGcd = 0;
            for (int j = i; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + n - 2;  
    }

    private int gcd(int number, int mod){
        while(mod != 0){
            int tempNumber = mod;
            mod = number % mod;
            number = tempNumber;
        }
        return number;
    }
}