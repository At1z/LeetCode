class Solution {
    public int mySqrt(int x) {
        double result = Math.sqrt(x);
        double square = Math.floor(result);
        return  (int)square;
    }
}