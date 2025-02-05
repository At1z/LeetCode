class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] t1 = new int[26];
        int[] t2 = new int[26];
        for(char c:s1.toCharArray()){
            t1[c - 'a'] += 1;
        }
        for(char c:s2.toCharArray()){
            t2[c - 'a'] += 1;
        }
        for(int i = 0; i < t1.length; i++){
            if(t1[i] != t2[i]){
                return false;
            }
        }
        int res = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                res += 1;
            }
            if(res > 2){
                return false;
            }
        }
        return true;
    }
}