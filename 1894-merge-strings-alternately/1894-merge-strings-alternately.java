class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int w1 = word1.length();
        int w2 = word2.length();
        int w1c = 0;
        int w2c = 0;
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        while(w1c < w1 || w2c < w2){
            if(w1c < w1){
                sb.append(c1[w1c]);
                w1c += 1;
            }
            if(w2c < w2){
                sb.append(c2[w2c]);
                w2c += 1;
            }
        }
        return sb.toString();
    }
}