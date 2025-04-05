class Solution {
public:
    int arrangeCoins(int n) {
        int i = 1;
        while(n > 0){
            n -= i;
            i++;
        }
        if(n < 0){
            return i - 2;
        }else if(n == 0){
            return i - 1;
        }            
        return -1;
    }
};