class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> indexes = new ArrayList<>();
        int maxDivistions = 0;
        int sumOfOnes = 0;
        int sumOfZeros = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) sumOfOnes += 1;
        }
        maxDivistions = sumOfOnes;
        indexes.add(0);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                sumOfZeros += 1;
            }else{
                sumOfOnes -= 1;
            }
            int newDivision = sumOfZeros + sumOfOnes;
            if(newDivision == maxDivistions) indexes.add(i+1);
            if(newDivision > maxDivistions){
                indexes = new ArrayList<>();
                indexes.add(i+1);
                maxDivistions = newDivision;
            }
        }

        return indexes;
    }
}