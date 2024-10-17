class Solution {
    public int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        char[] numChars = numStr.toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < numChars.length; i++) {
            System.out.println(numChars[i] - '0');
            last[numChars[i] - '0'] = i; 
        }
        for (int i = 0; i < numChars.length; i++) {
            for (int d = 9; d > numChars[i] - '0'; d--) {
                if (last[d] > i) {
                    char temp = numChars[i];
                    numChars[i] = numChars[last[d]];
                    numChars[last[d]] = temp;
                    return Integer.parseInt(new String(numChars));
                }
            }
        }
        return num;
    }
}
