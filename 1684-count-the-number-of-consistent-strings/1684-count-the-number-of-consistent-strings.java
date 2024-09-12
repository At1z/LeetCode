class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allow = new HashSet<Character>();
        int contain = words.length;
        for(char ch : allowed.toCharArray()){
            allow.add(ch);
        }
        for(int i = 0; i < words.length; i++){
            for(char ch : words[i].toCharArray()){
                if(!allow.contains(ch)){
                    contain -= 1;
                    break;
                } 
            }
        }
        return contain;
    }
}