class Solution {
    public String reverseOnlyLetters(String s) {
        HashMap<Integer, Character> noletter = new HashMap<>();
        List<Character> letters = new ArrayList<>();
        int place = 0;

        for (char ch : s.toCharArray()) {
            if (!Character.isLetter(ch)) {
                noletter.put(place, ch);
            } else {
                letters.add(ch);  
            }
            place++;
        }

        StringBuilder reverse = new StringBuilder(s.length());
        int letterIndex = letters.size() - 1; 

        for (int i = 0; i < s.length(); i++) {
            if (noletter.containsKey(i)) {
                reverse.append(noletter.get(i));
            } else {
                reverse.append(letters.get(letterIndex));
                letterIndex--;
            }
        }

        return reverse.toString();
    }
}