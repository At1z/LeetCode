class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] prefix = sentence.split(" ");
        for(int i = 0; i < prefix.length; i++){
            if(prefix[i].length() >= searchWord.length() && prefix[i].substring(0,searchWord.length()).equals(searchWord)){
                return i+1 ;
            }
        }
        return -1;
    }
}