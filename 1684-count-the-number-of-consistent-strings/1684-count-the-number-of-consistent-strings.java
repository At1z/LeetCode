class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allow = new HashSet<Character>();
        int contain = 0;
        for(char ch : allowed.toCharArray()){
            allow.add(ch);
        }
        for(int i = 0; i < words.length; i++){
            boolean have = true; 
            for(char ch : words[i].toCharArray()){
                if(allow.contains(ch)){
                    have = true;
                }else{
                    have = false;
                    break;
                }
            }
            if(have == true){
                contain += 1;
            }
        }
        return contain;
    }
}