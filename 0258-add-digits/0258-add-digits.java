class Solution {
    public int addDigits(int num) {
        while (num > 9) {  
            int curSum = 0;  
            for (char c : Integer.toString(num).toCharArray()) {
                curSum += c - '0';  
            }
            num = curSum;  
        }
        return num;
    }
}
