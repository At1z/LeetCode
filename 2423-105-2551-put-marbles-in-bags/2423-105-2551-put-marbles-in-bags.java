class Solution {
    public long putMarbles(int[] weights, int k) {
        long res = 0;
        long max = 0;
        long min = 0;
        ArrayList<Integer> splits = new ArrayList<>();
        for(int i = 1; i < weights.length; i++){
            splits.add(weights[i] + weights[i-1]);
        }
        Collections.sort(splits, (a,b) -> a-b);
        for(int i = 0; i < k - 1 ; i++){
            min += splits.get(i);

        }
        for(int i = splits.size()-k + 1; i < splits.size(); i++){
            max += splits.get(i);
        }

        return max - min;
    }
}