class Solution {
public:
    int isSuperDuper(int num){
        int res = 0;
        int size = num/2;
        for(int i = 1; i <= size; i++){
            if(num % i == 0){
                res += i;
            }
        }
        return res;
    }
    bool checkPerfectNumber(int num) {
        return isSuperDuper(num) == num;
    }
};