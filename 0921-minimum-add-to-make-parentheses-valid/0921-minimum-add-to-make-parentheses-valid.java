class Solution {
    public int minAddToMakeValid(String s) {
        int open_needed = 0;
        int close_needed = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                open_needed += 1;
                if(close_needed > 0){
                    open_needed -= 1;
                    close_needed -= 1;
                }
            }else{
                close_needed += 1;
            }
        }
        int res = Math.abs(open_needed + close_needed);
        return res;
    }
}