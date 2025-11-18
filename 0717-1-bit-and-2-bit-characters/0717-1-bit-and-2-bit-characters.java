class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i = 0; i< bits.length; i++){
            if(bits.length - 1 == i){
                return true;
            }
            if(bits[i] == 1){
                i++;
            }
        }

        return false;
    }
}