class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        // quicksort --> wrong order in answear
        int index = 0;
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            if(nums[i] < pivot){
                res[index++] = nums[i];
            }
        }
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == pivot){
                res[index++] = nums[i];
            }           
        }
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > pivot){
                res[index++] = nums[i];
            }
        }

        return res;
        /*
        List<Integer> less = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();
        List<Integer> equals = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                less.add(nums[i]);
            }else if(nums[i] == pivot){
                equals.add(nums[i]);
            }else{
                higher.add(nums[i]);
            }
        }
        less.addAll(equals);
        less.addAll(higher);
        int[] res = new int[nums.length];
        int index = 0;
        for(int num : less){
            res[index++] = num;
        }
        return res;
        */
    }
}