class Solution {
    public int[] minOperations(String boxes) {
        List<Integer> indexOfOnes = new ArrayList<>();
        for(int i = 0; i < boxes.length(); i++){
            if(boxes.charAt(i) == '1'){
                indexOfOnes.add(i);
            }
        }
        int[] res = new int[boxes.length()];
        for(int i = 0; i < boxes.length(); i++){
            for(int j = 0; j < indexOfOnes.size(); j++){
                res[i] += Math.abs(i - indexOfOnes.get(j));
            }
        }
        return res;
    }
}