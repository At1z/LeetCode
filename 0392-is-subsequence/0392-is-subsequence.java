class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        char[] cS = s.toCharArray();
        char[] cT = t.toCharArray();
        int iS = 0;
        for(int iT = 0; iT < t.length(); iT++){
            if(iS < s.length() && cS[iS] == cT[iT]){
                iS += 1;
            }
        }
        return (iS == s.length())?true:false;
    }
}