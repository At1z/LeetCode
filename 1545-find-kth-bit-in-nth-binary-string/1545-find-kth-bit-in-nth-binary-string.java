class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";
        for(int i = 0; i < n-1; i++){
            StringBuilder sb = new StringBuilder();
            for (char bit : s.toCharArray()) {
                if (bit == '0') {
                    sb.append('1');
                } else if (bit == '1') {
                    sb.append('0');
                }
            }
            s = s + "1" + sb.reverse().toString();
        }
        return s.charAt(k - 1);
    }
}