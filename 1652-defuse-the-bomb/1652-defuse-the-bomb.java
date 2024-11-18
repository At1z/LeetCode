class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0){
            return res;
        }
        if(k > 0){
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < i + k + 1; j++){
                    res[i] += code[j%n];
                }
            }
        }
        if (k < 0) {
            for (int i = 0; i < n; i++) {
                for (int j = i - 1; j > i + k - 1; j--) {
                    res[i] += code[(j + n) % n]; 
                }
            }
        }
        return res;
    }
}
/*
    class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0){
            return res;
        }
        if(k > 0){
            for(int i = 0; i < n; i++){
                int steps = 0;
                int step = i + 1;
                while(steps < k){
                    if(step > n - 1){
                        step = 0;
                    }
                    res[i] += code[step];
                    step += 1;
                    steps += 1;
                }
            }
        }
        if(k < 0){
            for(int i = 0; i < n; i++){
                int steps = 0;
                int step = i - 1;
                while(steps < Math.abs(k)){
                    if(step < 0){
                        step =  n - 1;
                    }
                    res[i] += code[step];
                    step -= 1;
                    steps += 1;
                }
            }
        }
        return res;
    }
}
*/