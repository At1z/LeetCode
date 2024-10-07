class Solution {
    String subString = "AB|CD";
    public int minLength(String s) {
        String res = remove(s);
        return res.length(); 
    }
    public String remove(String s){
        String curRes = s.replaceAll(subString, "");
        if(curRes.contains("AB") || curRes.contains("CD")){
            curRes = remove(curRes);
        }
        return curRes;    
    }
}