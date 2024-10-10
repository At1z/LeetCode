class Solution {

    public int maxWidthRamp(int[] nums) {
        Stack<Integer> Stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (Stack.isEmpty() || nums[Stack.peek()] > nums[i]) {
                Stack.push(i);
            }
        }
        int res = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            while (
                !Stack.isEmpty() && nums[Stack.peek()] <= nums[j]
            ) {
                res = Math.max(res, j - Stack.peek());
                Stack.pop();
            }
        }

        return res;
    }
}