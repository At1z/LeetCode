class Solution {
    public int minSteps(int n) {
        int sumOfSteps = 0;
        int divider = 2;
        while(n > 1){
            while(n % divider == 0){
                sumOfSteps += divider;
                n /= divider;
            }
            divider += 1;

        }
        return sumOfSteps;
    }
}