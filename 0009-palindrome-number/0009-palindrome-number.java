class Solution {
    public boolean isPalindrome(int x) {
        boolean answear = false;
        String number = Integer.toString(x);
        String reversedNumber = "";
        char stringNumber;
        for (int i=0; i<number.length(); i++){
            stringNumber = number.charAt(i);
            reversedNumber= stringNumber+reversedNumber;
         }
        if(reversedNumber.equals(number)){
                answear = true;
        }
    return answear;
    }
}