class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] prefix = new int[s.length() + 1]; 
        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int increment = (shifts[i][2] == 1) ? 1 : -1;
            prefix[start] += increment;
            if (end + 1 < prefix.length) {
                prefix[end + 1] -= increment;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            prefix[i] += prefix[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int result = ((s.charAt(i) - 'a' + prefix[i]) % 26 + 26) % 26;
            sb.append((char)(result + 'a'));
        }  
         return sb.toString();
    }
}