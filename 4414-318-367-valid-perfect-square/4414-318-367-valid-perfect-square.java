class Solution {
    public boolean isPerfectSquare(int num) {
    //  return (int)Math.sqrt(num) == Math.sqrt(num); -works fine but it want to use binary search
        if(num == 1){
            return true;
        }
        int l = 1;
        int r = num/2;
        while(l <= r){
            int mid = l + (r-l)/2;
            long curMidPower = ((long)mid * (long)mid);
            if( curMidPower == num){
                return true;
            }else if (curMidPower > num){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}