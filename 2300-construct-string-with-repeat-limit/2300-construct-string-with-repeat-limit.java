class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        int maxIndex = 25;
        while(maxIndex >= 0){
            if(freq[maxIndex] == 0){
                maxIndex -= 1;
                continue;
            }
            int rep = Math.min(repeatLimit,freq[maxIndex]);
            freq[maxIndex] -= rep;
            while(rep > 0){
                sb.append((char) ('a' + maxIndex));
                rep -= 1;
            }
            if (freq[maxIndex] > 0) { 
                int smallIndex = maxIndex - 1;
                while (smallIndex >= 0 && freq[smallIndex] == 0) {
                    smallIndex -= 1;
                }
                if (smallIndex < 0) {
                    break;
                }
                sb.append((char) ('a' + smallIndex));
                freq[smallIndex]--;
            }
        }
        return sb.toString();
    }
}