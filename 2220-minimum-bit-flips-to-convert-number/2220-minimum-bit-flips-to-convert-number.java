class Solution {
    public int minBitFlips(int start, int goal) {
        String binstart = Integer.toBinaryString(start);
        String bingoal = Integer.toBinaryString(goal);
        int i = binstart.length()-1;
        int j = bingoal.length()-1;
        int counter = 0;
        while(i>=0 || j>=0){
            if(j < 0){
                if(binstart.charAt(i) == '1'){
                counter += 1;
                }
                i--;
                continue;
            }
            if(i < 0){
                if( bingoal.charAt(j) == '1'){  
                counter += 1;
                }
                j--;
                continue;
            }
            if(binstart.charAt(i) != bingoal.charAt(j)){
                counter += 1;
            }
            i--;
            j--;
        }
        return counter;
        }
}
