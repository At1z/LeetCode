class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        List<int[]> pairs = new ArrayList<>();
        int n = arr.length;
        int res = 0;
        for(int i = 0; i < n-2; i++){
            for(int j = i + 1; j < n-1; j++){
                if(Math.abs(arr[i] - arr[j]) <= a){
                    pairs.add(new int[]{i,j});
                }
            }
        }
        for(int i = 0; i < pairs.size(); i++){
            int[] curPair = pairs.get(i);
            for(int j = curPair[1] + 1; j < n; j++){
                if(
                    Math.abs(arr[curPair[1]] - arr[j]) <= b &&
                    Math.abs(arr[curPair[0]] - arr[j]) <= c
                ){
                    res += 1;
                }
            }
        }
        

        return res;
    }
}