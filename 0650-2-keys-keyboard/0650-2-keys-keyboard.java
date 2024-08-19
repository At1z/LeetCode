class Solution {
    public int minSteps(int n) {
        int sumOfSteps = 0;
        while(n > 1){
            if (n % 2 == 0){
                n /= 2;
                sumOfSteps += 2;
                continue;
            }
              if (n % 3 == 0){
                n /= 3;
                sumOfSteps += 3;
                continue;
            }
                int smallest = findSmallestDivisor(n);
                sumOfSteps += smallest;
                n /= smallest;
            }

        return sumOfSteps;
    }
     static int findSmallestDivisor(int number) {
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return i;
            }
        }
        return number;
    }
}