class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] numsSorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) numsSorted[i] = nums[i];
        Arrays.sort(numsSorted);
        int currGroup = 0;
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);

        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(
            currGroup,
            new LinkedList<Integer>(Arrays.asList(numsSorted[0]))
        );
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) {
                currGroup++;
            }
            numToGroup.put(numsSorted[i], currGroup);
            if (!groupToList.containsKey(currGroup)) {
                groupToList.put(currGroup, new LinkedList<Integer>());
            }
            groupToList.get(currGroup).add(numsSorted[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }
        return nums;
        /*
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] > nums[j] && nums[i] - nums[j] <= limit){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j = i;
                }
            }
        }
        return nums;
        */
    }
}