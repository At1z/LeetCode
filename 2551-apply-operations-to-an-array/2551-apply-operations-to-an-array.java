class Solution {
    public int[] applyOperations(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2;  // Double the number
                nums[i + 1] = 0; // Set next to zero
            }
        }
        for (int num : nums) {
            if (num != 0) {
                queue.add(num);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            nums[index++] = queue.poll();
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }

        return nums;
    }
}
