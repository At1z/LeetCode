class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sumInNums1 = 0;
        long zeroInNums1 = 0;
        long sumInNums2 = 0;
        long zeroInNums2 = 0;

        for(int i = 0; i < nums1.length; i++){
            sumInNums1 += nums1[i];
            if(nums1[i] == 0){
                zeroInNums1 += 1;
            }
        }
        for(int i = 0; i < nums2.length; i++){
            sumInNums2 += nums2[i];
            if(nums2[i] == 0){
                zeroInNums2 += 1;
            }
        }
        if(sumInNums1 == sumInNums2 && zeroInNums1 == zeroInNums2){
            return sumInNums1 + zeroInNums1;

        }else if(sumInNums1 > sumInNums2){
            if(zeroInNums2 < 1){
                return -1;
            }
            if(zeroInNums1 == 0 && sumInNums2 + zeroInNums2 > sumInNums1){
                return -1;
            }
            if(sumInNums1 + zeroInNums1 >= sumInNums2 + zeroInNums2){
                return sumInNums1 + zeroInNums1;
            }else{
                return sumInNums2 + zeroInNums2;
            }
        }else{
            if(zeroInNums1 < 1){
                return -1;
            }
            if(zeroInNums2 == 0 && sumInNums1 + zeroInNums1 > sumInNums2){
                return -1;
            }
            if(sumInNums2 + zeroInNums2 >= sumInNums1 + zeroInNums1){
                return sumInNums2 + zeroInNums2;
            }else{
                return sumInNums1 + zeroInNums1;
            }
        }
    }
}