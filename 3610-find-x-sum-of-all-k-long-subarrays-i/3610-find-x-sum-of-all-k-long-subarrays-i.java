class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int l = 0;
        int r = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        while(r < nums.length){
            while((r - l) < k){
                frequencyMap.put(nums[r], frequencyMap.getOrDefault(nums[r],0) + 1);
                r += 1;
            }
            List<Map.Entry<Integer, Integer>> sortedByFrequency = new ArrayList<>(frequencyMap.entrySet());
            sortedByFrequency = sortedByFrequency.stream()
                .sorted(Comparator
                    .comparing(Map.Entry<Integer, Integer>::getValue, Comparator.reverseOrder())
                    .thenComparing(Map.Entry<Integer, Integer>::getKey, Comparator.reverseOrder())
                )
                .collect(Collectors.toList());
            if(sortedByFrequency.size() < x){
                for(int i = 0; i < sortedByFrequency.size(); i++){
                    res[index] += sortedByFrequency.get(i).getKey() * sortedByFrequency.get(i).getValue();
                } 
            }else{
                for(int i = 0; i < x; i++){
                    res[index] += sortedByFrequency.get(i).getKey() * sortedByFrequency.get(i).getValue();
                } 
            }
            int count = frequencyMap.get(nums[l]) - 1;
            if (count == 0) {
                frequencyMap.remove(nums[l]);
            } else {
                frequencyMap.put(nums[l], count);
            }
            l+= 1;
            System.out.println(l);
            index += 1;
        }
        return res;
    }
}