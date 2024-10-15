class Solution {
    public long minimumSteps(String s) {
        long res = 0;
        long onecouter = 0;
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '1'){
                onecouter += 1;
            }else{
                res += onecouter;
            }
        }
        return res;
    }
}