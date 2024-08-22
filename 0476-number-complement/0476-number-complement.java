class Solution {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        StringBuilder reversedBinary = new StringBuilder();
        for (char ch : bin.toCharArray()) {
            if (ch == '1') {
                reversedBinary.append('0');
            } else if (ch == '0') {
                reversedBinary.append('1');
            } else {
                reversedBinary.append(ch);
            }
        }
        String reversedBinaryString = reversedBinary.toString();
        int result = Integer.parseInt(reversedBinaryString, 2);


       return result;
    }
}



