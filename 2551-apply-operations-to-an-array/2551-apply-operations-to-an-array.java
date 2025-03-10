class Solution {
    public int[] applyOperations(int[] nums) {
        Queue<Integer> num = new LinkedList<>();
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1] && nums[i-1] != 0){
                num.add(nums[i-1] * 2);
                nums[i] = 0;
            }else if(nums[i] != nums[i-1]){
                if(nums[i-1] != 0){
                    num.add(nums[i-1]);
                }
            }
            if(nums.length-1 == i){
                if(nums[i] != 0){
                    num.add(nums[i]);
                }
            }
        }
        int index = 0;
        while(!num.isEmpty()){
            nums[index++] = num.poll();
        }
        while(index < nums.length){
            nums[index++] = 0;
        }
        return nums;
    }
}