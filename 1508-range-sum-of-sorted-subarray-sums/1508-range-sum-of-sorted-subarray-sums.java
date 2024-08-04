import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarraySums = new ArrayList<>();
        int mod = 1_000_000_007;
        
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                subarraySums.add(currentSum);
            }
        }
        
        Collections.sort(subarraySums);
        
        long result = 0;
        for (int k = left - 1; k < right; k++) {
            result = (result + subarraySums.get(k)) % mod;
        }
        
        return (int) result;
    }
}
