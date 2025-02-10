class Solution {

    public String clearDigits(String s) {
        StringBuilder res = new StringBuilder();
        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            if (
                Character.isDigit(s.charAt(charIndex)) && res.length() != 0
            ) {
                res.setLength(res.length() - 1);
            } else {
                res.append(s.charAt(charIndex));
            }
        }

        return res.toString();
    }
}