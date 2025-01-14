class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> prefix = new HashSet<>();
        int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++){
            if(i > 0){
                res[i] += res[i-1];
            }
            if(A[i] == B[i]){
                prefix.add(A[i]);
                res[i] += 1;
            }else{
                if(prefix.contains(A[i])){
                    res[i] += 1;
                }
                if(prefix.contains(B[i])){
                    res[i] += 1;
                }
                prefix.add(A[i]);
                prefix.add(B[i]);
            }
        }
        return res;
    }
}