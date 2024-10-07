class Solution {
    private boolean[] generatePrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true; 
        }
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false; 
                }
            }
        }
        return isPrime;
    }
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> pairs = new ArrayList<>();
        if (n < 2) {
            return pairs; 
        }
        boolean[] isPrime = generatePrimes(n); 
        for (int x = 2; x <= n / 2; x++) {
            int y = n - x;
            if (isPrime[x] && isPrime[y] && x <= y) { 
                List<Integer> pair = new ArrayList<>();
                pair.add(x);
                pair.add(y);
                pairs.add(pair);
            }
        }
        return pairs; 
    }
}