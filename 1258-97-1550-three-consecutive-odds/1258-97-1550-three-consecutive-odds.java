class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutiveOddsNumbersCounter = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                consecutiveOddsNumbersCounter += 1;
            }else{
                consecutiveOddsNumbersCounter = 0;
            }
            if(consecutiveOddsNumbersCounter == 3){
                return true;
            }

        }


        return false;
    }
}