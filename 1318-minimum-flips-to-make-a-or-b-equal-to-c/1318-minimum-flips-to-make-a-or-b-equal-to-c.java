class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a > 0 || b > 0 || c > 0){
            if((a & 1) ==  (c & 1) && (b & 1) ==  (c & 1)){
                a >>= 1;
                b >>= 1;
                c >>= 1;
                continue;
            }
            if((a & 1) !=  (c & 1) && (b & 1) !=  (c & 1)){
                if ((c & 1) == 0){
                    count += 1;
                }
                count += 1;
                a >>= 1;
                b >>= 1;
                c >>= 1;
                continue;
            }
            if((a & 1) ==  (c & 1) || (b & 1) ==  (c & 1)){
                if((c & 1) == 0){
                    count += 1;
                }
                a >>= 1;
                b >>= 1;
                c >>= 1;
                continue;
            }
        }       
    return count;
    }
}