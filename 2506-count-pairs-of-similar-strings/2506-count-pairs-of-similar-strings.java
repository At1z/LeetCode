class Solution {
    public int similarPairs(String[] words) {
        int contains = 0;
        for(int i = 0; i < words.length; i++){
            HashSet<Character> allowedWord = new HashSet<Character>();
            for(char ch : words[i].toCharArray()){
                allowedWord.add(ch);
            }
            for(int j = i + 1; j < words.length; j++){
                HashSet<Character> allowedNextWord = new HashSet<Character>();
                    for(char ch : words[j].toCharArray()){
                    allowedNextWord.add(ch);
                }
                if(allowedWord.equals(allowedNextWord)){
                    contains += 1;
                }
            }
        }
        return contains;
    }
}