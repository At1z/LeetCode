class Solution {
    public String convertToTitle(int columnNumber) {
        Map<Integer, Character> numberToLetter = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            numberToLetter.put(i, (char) ('A' + i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;
            sb.append(numberToLetter.get(columnNumber % 26));
            columnNumber /= 26;
        }
        
        return sb.reverse().toString();
    }
}