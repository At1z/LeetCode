class Solution {
    public int minSwaps(String s) {
        int res = 0;
        int stackSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                stackSize += 1;
            } else {
                if (stackSize > 0) {
                    stackSize -= 1;
                } else {
                    res += 1;
                }
            }
        }
        return (res + 1) / 2;
    }
}
