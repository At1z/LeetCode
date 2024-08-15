class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                five += 1;
                continue;
            }
            if(bills[i] == 10 && five != 0){
                five -= 1;
                ten += 1;
                continue;
            }
            if(bills[i] == 20 && five != 0 && ten != 0){
                five -= 1;
                ten -= 1;
                continue;
            }
            if(bills[i] == 20 && five >= 3){
                five -= 3;
                continue;
            }
            return false;
        }  
        return true;
    }
}