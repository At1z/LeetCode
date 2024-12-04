class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] c2 = str2.toCharArray();
        char[] c1 = str1.toCharArray();
        int index = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (index == str2.length()) {
                return true;
            }

            int temp = c1[i] - 'a';
            int target = c2[index] - 'a';
            if (temp == target || (temp + 1) % 26 == target) {
                index++;
            }
        }

        return index == str2.length();
    }
}
