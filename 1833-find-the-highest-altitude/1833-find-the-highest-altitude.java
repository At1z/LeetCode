class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int altitude = 0;
        for(int i = 0; i < gain.length; i++){
            altitude += gain[i];
            res = Math.max(res,altitude);
        }
        return res;
    }
}