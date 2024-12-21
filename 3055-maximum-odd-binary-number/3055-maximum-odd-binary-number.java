class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int one = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '1'){
                one += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < one - 1; i++) {
            sb.append("1");
        }
        for (int i = 0; i < n - one; i++) {
            sb.append("0");
        }
        sb.append("1");
        return sb.toString();
    }
}