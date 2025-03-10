class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeast(word, k) - atLeast(word, k + 1);
    }
    public long atLeast(String word, int k){
        if(word.length() < 5){
            return 0;
        }
        Set<Character> consonants = new HashSet<>();
        for(char c : new char[]{'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'}) {
            consonants.add(c);
        }
        int[] freq = new int[26];
        int cons = 0;
        long res = 0;
        int l = 0;
        int r = 0;
        while(r < word.length()){
            char ch = word.charAt(r);
            freq[ch - 'a']++;
            if(consonants.contains(ch)){
                cons += 1;
            }
            while(cons >= k && valid(freq)){
                res += word.length() - r;
                char ch2 = word.charAt(l);
                if(consonants.contains(ch2)){
                    cons -= 1;
                }
                freq[ch2 - 'a']--;
                l += 1;
            }
            r += 1;
        }
        return res;
    }
    public boolean valid(int[] freq ){
        if(freq['a' - 'a'] > 0 && freq['e' - 'a'] > 0 && freq['i' - 'a'] > 0 && freq['o' - 'a'] > 0 && freq['u' - 'a'] > 0){
            return true;
        }
    return false;
    }

}