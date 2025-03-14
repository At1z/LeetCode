class Solution {
    public int maximumCandies(int[] candies, long k) {
    if(k < 1){
        return 0;
    }
    long l = 1;
    long r = 0;
    for(int candie : candies){
        r = Math.max(r,candie);
    }
    while(l <= r){
        long mid = l + (r - l)/2;
        long counter = 0;
        for(int candie : candies){
            counter += candie/mid;
        }
        if(counter >= k){
            l = mid + 1;
        }else{
            r = mid - 1;
        }
    }
    return (int)l - 1;
    }
}