class Solution {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        Set<Character> seenCharacters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seenCharacters.contains(c)) {
                continue;
            }
            seenCharacters.add(c);
            int lastIndex = s.length() - 1;
            while(lastIndex > i && c != s.charAt(lastIndex)){
                lastIndex -= 1;
            }
            Set<String> uniquePalindromes = new HashSet<>();
            for (int j = i + 1; j < lastIndex; j++) {
                String palindrome = c + "" + s.charAt(j) + c;
                if (uniquePalindromes.add(palindrome)) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
