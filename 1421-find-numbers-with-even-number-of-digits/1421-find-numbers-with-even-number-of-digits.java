class Solution {
    public int findNumbers(int[] nums) {
        int evenDigits = 0;
        for(int num : nums){
            if(hasEvenDigits(num)){
                evenDigits += 1;
            }
        }
        return evenDigits;
    }

    public boolean hasEvenDigits(int num){
        int digitsCounter = 0;
        while(num > 0){
            digitsCounter += 1;
            num /= 10;
        }
        return digitsCounter % 2 == 0;
    }
}