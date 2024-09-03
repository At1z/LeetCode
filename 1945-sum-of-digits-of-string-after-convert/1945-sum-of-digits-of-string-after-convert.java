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
}
