class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int emptyCounter = 0;
        for(int i = 0; i < flowerbed.length; i++){
            boolean emptyLeft = false;
            boolean emptyRight = false;
            if(flowerbed[i] == 0 ){
                emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
                emptyRight = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                
            }
            if (emptyLeft && emptyRight) {
                emptyCounter += 1;
                flowerbed[i] = 1;
            }
        }
        return emptyCounter >= n;
    }
}