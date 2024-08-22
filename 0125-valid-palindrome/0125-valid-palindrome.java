class Solution {
    public boolean isPalindrome(String s) {
        String palindrome = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        StringBuilder reversedPalindrome = new StringBuilder(palindrome).reverse();
        return palindrome.equals(reversedPalindrome.toString());
    }
}