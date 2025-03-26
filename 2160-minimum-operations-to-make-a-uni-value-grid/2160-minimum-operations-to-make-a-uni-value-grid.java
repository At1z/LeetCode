class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        for (int[] row : grid) {
            for (int num : row) {
                nums.add(num);
            }
        }
        Collections.sort(nums);
        
        int remainder = nums.get(0) % x;
        for (int num : nums) {
            if (num % x != remainder) {
                return -1;  // Not possible
            }
        }
        
        // Find the median
        int median = nums.get(nums.size() / 2);
        
        // Compute the number of operations to make all elements equal to the median
        int operations = 0;
        for (int num : nums) {
            operations += Math.abs(num - median) / x;
        }
        
        return operations;    
    }
}