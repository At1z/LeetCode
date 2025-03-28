class Solution {
    public long repairCars(int[] ranks, int cars) {
        /// (200:4)^(1/2) = (50)^(1/2) ~= 7 
        long l = 1;
        long r = 0;
        for(int i = 0; i < ranks.length; i++){
            r = (long)Math.max(r,(long)ranks[i] * ((long)cars * (long)cars));
        }
        while(l <= r){
            long mid = l + (r-l)/2;
            long counter = 0;
            for(int i = 0; i < ranks.length; i++){
                counter += (long)Math.sqrt((mid/ranks[i]));
                if(counter >= cars){
                    break;
                }
            }

            if(counter >= cars){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}