class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] freq = new int[3];
        int l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'a']++;
            
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) { 
                res += s.length() - r; 
                freq[s.charAt(l) - 'a']--;
                l++;
            }
        }
        
        return res;
    }
}