class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++){
            res = builder(res);
        }
        return res;
    }
    public String builder(String rle){
        StringBuilder res = new StringBuilder();
        int counter = 1;
        char prevChar = rle.charAt(0);
        for(int i = 1; i < rle.length(); i++){
            if(rle.charAt(i) == prevChar){
                counter += 1;
            }else{
                res.append(counter).append(prevChar);
                counter = 1;
                prevChar = rle.charAt(i);
            }
        }
        res.append(counter).append(prevChar);
        return res.toString();
    }
}