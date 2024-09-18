class Solution {
    public long smallestNumber(long num) {
        boolean isNegative = num < 0;
        String numStr = Long.toString(Math.abs(num));
        char[] digits = numStr.toCharArray();
        Arrays.sort(digits);

        if (isNegative) {
            StringBuilder sb = new StringBuilder();
            for (int i = digits.length - 1; i >= 0; i--) {
                sb.append(digits[i]);
            }
            return Long.parseLong("-" + sb.toString());
        } else {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < digits.length && digits[i] == '0') {
                i++;
            }
            if (i < digits.length) {

                sb.append(digits[i]);
                for (int j = 0; j < i; j++) {
                    sb.append('0');
                }
                for (int j = i + 1; j < digits.length; j++) {
                    sb.append(digits[j]);
                }
            } else {
                sb.append('0');
            }
            return Long.parseLong(sb.toString());
        }
    }
}