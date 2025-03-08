class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0;
        int r = 0;
        int w = 0;
        int b = 0;
        int res = 0;
        while(l < blocks.length()){
            while(r - l < k  && r < blocks.length()){
                if(blocks.charAt(r) == 'W'){
                    w += 1;
                }else{
                    b += 1;
                }
                r += 1;
            } 
            res = Math.max(res,b);
            if(res >= k){
                return 0;
            }
            if(blocks.charAt(l) == 'W'){
                w -= 1;
            }else{
                b -= 1;
            }
            l += 1;
        }
        return k - res;
    }
}