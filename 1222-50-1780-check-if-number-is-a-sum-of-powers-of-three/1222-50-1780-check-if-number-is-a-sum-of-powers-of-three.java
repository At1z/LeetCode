class Solution {
    public boolean checkPowersOfThree(int n) {
        boolean res = tri(1,n);
        return res;
    }
    public boolean tri(int curTri, int curN){
        if(curN < 0){
            return false;
        }else if( curN == 0){
            return true;
        }
        for(int i = curTri; i <= curN;){
            if(tri(i*3, curN - i)){
                return true;
            }
            i *= 3;
        }
        return false ;
    }
}
