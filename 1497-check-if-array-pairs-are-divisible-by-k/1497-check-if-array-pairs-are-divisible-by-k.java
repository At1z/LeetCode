class Solution {

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        for (int i : arr) {
            int rem = ((i % k) + k) % k;
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }
        for (int i : arr) {
            int rem = ((i % k) + k) % k;
            if (rem == 0) {
                if (remainderCount.get(rem) % 2 == 1) return false;
            }
            else if (
                !Objects.equals(
                    remainderCount.get(rem),
                    remainderCount.get(k - rem)
                )
            ) return false;
        }
        return true;
    }
}
        /* brute force :) 91/97
        int res = 0;
        boolean[] used = new boolean[arr.length]; 
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue; 
            
            for (int j = i + 1; j < arr.length; j++) { 
                if (!used[j] && (arr[i] + arr[j]) % k == 0) {
                    used[i] = true; 
                    used[j] = true;
                    res += 1;       
                    break;
                }
            }
        }
        return res == arr.length / 2;
        */
