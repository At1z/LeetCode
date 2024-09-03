class Solution {
    public int getLucky(String s, int k) {
         HashMap<Character, Integer> alphabetMap = new HashMap<>();


        for (char c = 'a'; c <= 'z'; c++) {
            alphabetMap.put(c, c - 'a' + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(alphabetMap.get(c));
        }

        String currentString = sb.toString();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = 0;
            for (char c : currentString.toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            currentString = Integer.toString(sum);
        }

        return sum;
    }
        public static int splitDigits(int number) {
        String numberString = Integer.toString(number);
        int sum = 0;
        for (char digitChar : numberString.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            sum += digit;
        }
        return sum;
    }
}