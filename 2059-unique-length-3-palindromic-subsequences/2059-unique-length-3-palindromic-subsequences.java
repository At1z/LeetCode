class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        Set<String> uniquePalindromes = new HashSet<>();
        Set<Character> seenCharacters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seenCharacters.contains(c)) {
                continue;
            }
            seenCharacters.add(c);
            int lastIndex = s.lastIndexOf(c);
            if (lastIndex <= i) {
                continue;
            }
            for (int j = i + 1; j < lastIndex; j++) {
                String palindrome = c + "" + s.charAt(j) + c;
                if (uniquePalindromes.add(palindrome)) {
                    res++;
                }
            }
        }
        return res;
    }
}
