class Solution {
    String subString = "AB|CD";
    public int minLength(String s) {
        String res = remove(s,s.length());
        return res.length(); 
    }
    public String remove(String s, int length){
        String curRes = s.replaceAll(subString, "");
        if(curRes.length() != length){
            curRes = remove(curRes, curRes.length());
        }
        return curRes;    
    }
}