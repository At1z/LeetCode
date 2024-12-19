class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum == i*(i+1)/2){
                res += 1;
            }
        }
        return res;
    }
}