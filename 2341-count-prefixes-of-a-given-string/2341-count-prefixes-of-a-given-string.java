class Solution {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].length() <= s.length() && s.substring(0,words[i].length()).equals(words[i])){
                res += 1;
            } 
        }
    return res;
    }
}