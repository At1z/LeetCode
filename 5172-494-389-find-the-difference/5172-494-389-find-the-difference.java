class Solution {
    public char findTheDifference(String s, String t) {
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];
        for(int i = 0; i < s.length(); i++){
            sFreq[s.charAt(i) - 'a'] += 1;
            tFreq[t.charAt(i) - 'a'] += 1;
        }
        tFreq[t.charAt(t.length() - 1) - 'a'] += 1;
        for(int i = 0; i < 26; i++){
            if(sFreq[i] != tFreq[i]){
                return (char)('a'+ i);
            }
        }
        return '0';
    }
}