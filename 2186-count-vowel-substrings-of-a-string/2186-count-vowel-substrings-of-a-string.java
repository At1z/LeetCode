class Solution {
    public int countVowelSubstrings(String word) {
        int res = 0;
        char[] freq = new char[26];
        int l = 0;
        while(l < word.length()){
            int r = l;
            while(r < word.length() && isValidChar(word.charAt(r))){
                freq[word.charAt(r) - 'a']++;
                if(isValidSequence(freq)){
                    res += 1;
                }
                r += 1;
            }
            int tempL = l;
            while(l < r){
                char ch2 = word.charAt(l);
                freq[ch2 - 'a']--;
                l += 1;
            }
            l = tempL + 1;
            }
            return res;
    }
    public boolean isValidChar(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }
     public boolean isValidSequence(char[] freq) {
        return freq['a' - 'a'] > 0 && freq['e' - 'a'] > 0 && freq['i' - 'a'] > 0 && freq['o' - 'a'] > 0 && freq['u' - 'a'] > 0;
    }

}