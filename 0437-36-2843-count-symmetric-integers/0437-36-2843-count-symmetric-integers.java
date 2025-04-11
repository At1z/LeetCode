class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for(int i = low; i <= high; i++){
            if(i > 10 && i <100 && i % 11 == 0){
                res += 1;
            }else if(i > 1000 && i < 10000){
                int a = i; // 1000
                int b = (i % 1000); // 100
                int c = (i % 100); // 10
                int d = i % 10;
                if (a/1000 + b/100 == c/10 + d){
                    res += 1;
                }
            }
        }
        return res;
    }
}