class Solution {
    public int countTriples(int n) {
        Set<Integer> squares = new HashSet<>();
        int res = 0;
        for(int i = 1; i <= n; i++){
            squares.add(i*i);
        }
        for(int i = 1 ; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if( i != j && squares.contains(i*i + j*j)){
                    res += 1;
                }
            }
        }
        return res;
    }
}