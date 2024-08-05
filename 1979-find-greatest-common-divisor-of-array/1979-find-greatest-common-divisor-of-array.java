import java.util.Arrays;

class Solution {
    public int findGCD(int[] nums) {
        int gcd = 0;
        Arrays.sort(nums);
        int absNumber1 = Math.abs(nums[0]);
        int absNumber2 = Math.abs(nums[nums.length-1]);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
            while (lcm % absLowerNumber != 0) {
             lcm += absHigherNumber;
            }
        gcd = (nums[0] * nums[nums.length-1])/lcm;
    return gcd;
    }
}