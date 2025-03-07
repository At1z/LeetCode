class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(isPrimal(i)){
                primes.add(i);
            }
        }

        if(primes.size() < 2){
            return new int[]{-1,-1};
        }
        
        int minDist = Integer.MAX_VALUE;
        int prime1 = -1, prime2 = -1;

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDist) {
                minDist = diff;
                prime1 = primes.get(i - 1);
                prime2 = primes.get(i);
            }
        }

        return new int[]{prime1, prime2};
        /*
        int num1 = -1;
        int num2 = -1;
        int dist = Integer.MAX_VALUE;
        int prev = 0;
        for(int i = left; i <= right; i++){
            if(isPrimal(i)){
                if(num1 == -1){
                    num1 = i;
                    continue;
                }
                if(num2 == -1){
                    num2 = i;
                    dist = num2 - num1;
                    prev = num2;
                    continue;
                }
                if(dist > (i - prev)){
                    num1 = prev;
                    num2 = i;
                    dist = num2 - num1;
                }
                prev = i;
            }
        }
        return (num2 == -1)? new int[]{-1,-1}: new int[]{num1,num2};
        */
    }
    public boolean isPrimal(int number){
        if(number <= 1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}