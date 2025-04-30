class Solution {
    public int findNumbers(int[] nums) {
        int numbersWithEvenDigits = 0;
        for(int num : nums){
            if(hasEvenDigits(num)){
                numbersWithEvenDigits += 1;
            }
        }
        return numbersWithEvenDigits;
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