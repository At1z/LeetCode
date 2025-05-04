class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> pairs = new HashMap<>();
        int res = 0;
        for(int[] domino : dominoes){
            Arrays.sort(domino);
            String newPair = Arrays.toString(domino);
            pairs.put(newPair, pairs.getOrDefault(newPair,0) + 1);
        }
        for(int value : pairs.values()){
            if(value > 1){
                res += value * (value - 1)/2;
            }
        }
        return res;
    }
}