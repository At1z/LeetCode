class Solution {
    public int maxScore(String s) {
        int res = 0;
        for(int i = 1; i < s.length(); i++){
            int left = left(s.substring(0,i));
            int right = right(s.substring(i,s.length()));
            res = Math.max(res, left + right);
        }
        return res;
    }
    public int left(String left){
        int res = 0;
        for(char c:left.toCharArray()){
            if( c == '0'){
                res += 1;
            } 
        }
        return res;
    }
    public int right(String right){
        int res = 0;
        for(char c:right.toCharArray()){
            if( c == '1'){
                res += 1;
            } 
        }
        return res;
    }
}