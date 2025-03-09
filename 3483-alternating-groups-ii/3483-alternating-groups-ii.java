class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] extendedArr = new int[colors.length + (k - 1)];
        int res = 0;
        System.arraycopy(colors, 0, extendedArr, 0, colors.length);
        System.arraycopy(colors, 0, extendedArr, colors.length, k - 1);
        int counter = 1;
        for(int i = 1; i < extendedArr.length; i++){
            if(extendedArr[i] != extendedArr[i-1]){
                counter += 1;
            }else{
                counter = 1;
            }
            if(counter == k){
                res += 1;
                counter -= 1;
            }
        }
        return res;
    }
}