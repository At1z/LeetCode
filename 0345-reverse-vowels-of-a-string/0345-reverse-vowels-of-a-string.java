class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        String check = "aeiouAEIOU";
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            while(left < right && check.indexOf(c[left]) == -1){
                left += 1;
            }
            while(left < right && check.indexOf(c[right]) == -1){
                right -= 1;
            }
            char temp = c[right];
            c[right] = c[left];
            c[left] = temp;
            left += 1;
            right -= 1;
        }
        return new String(c);
    }
}