class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a'] += 1;
        }
        int res = 0;
        for(int i = 0; i< freq.length; i++){
            if (freq[i] > 2) {
                if(freq[i] % 2 == 0){
                    res += 2;
                }else{
                    res += 1;
                }
            } else {
                res += freq[i];
            }
        }
        return res;
    }
}