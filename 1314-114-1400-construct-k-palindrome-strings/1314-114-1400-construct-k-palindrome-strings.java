class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length()){
            return false;
        }
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a'] += 1;
        }
        int oddNumbers= 0;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] % 2 != 0){
                oddNumbers += 1;
            }
        }
        return k >= oddNumbers;
    }
}