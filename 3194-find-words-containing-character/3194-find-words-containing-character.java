class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> containsX = new ArrayList<>();
        String X = Character.toString(x);
        for(int i = 0; i < words.length; i++){
            if(words[i].contains(X)){
                containsX.add(i);
            }
        }
        return containsX;
    }
}