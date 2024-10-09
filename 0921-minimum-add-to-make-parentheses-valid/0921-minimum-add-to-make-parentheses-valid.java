class Solution {
    public int minAddToMakeValid(String s) {
        int open_needed = 0;
        int close_needed = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(close_needed > 0){
                    close_needed -= 1;
                    continue;
                }
                    open_needed += 1;
            }else{
                close_needed += 1;
            }
        }
        return open_needed + close_needed;
    }
}