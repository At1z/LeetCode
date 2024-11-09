class Solution {
    public long minEnd(int n, int x) {
        long num = x;
        while(n > 1){
            num = (num+1)|x;
            n -= 1;
        }
        return num;
    }
}