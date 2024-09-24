class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefSet = new HashSet<>();
        for (int num : arr1) {
            while(num > 0){
                prefSet.add(num);
                num /= 10;
            }    
        }
        int res = 0;
        for(int i = 0; i < arr2.length; i++){
            int curres = arr2[i];
            while( curres > 0){
                if(prefSet.contains(curres)){
                    res = Math.max(res,String.valueOf(curres).length());
                }
                curres /= 10;
            }
        }
        return res;
    }
}