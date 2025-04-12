class Solution {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        int aLength = a.length();
        int bLength = b.length();
        int res = 0;
        if(aLength > bLength){
            for(int i = 0; i < b.length(); i++){
                if(!a.contains(b.substring(i))){
                    res = i;
                    break;
                }
            }
        }else{
            for(int i = 0; i < a.length(); i++){
                if(!b.contains(a.substring(i))){
                    res = i;
                    break;
                }
            }

        }
        return (aLength > bLength)? aLength - res: bLength - res;
    }
}