public class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> subseq = new ArrayList<>();

        for (int num : nums) {
            int index = Collections.binarySearch(subseq, num);
            if (index < 0) {
                index = -(index + 1); 
            }
            if (index == subseq.size()) {
                subseq.add(num); 
            } else {
                subseq.set(index, num); 
            }
        }

        return subseq.size();
    }
}
