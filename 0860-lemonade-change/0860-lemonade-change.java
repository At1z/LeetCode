class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] != 5 ){
            return false;
        }
        int [ ] exchange = new int [2]; // [0] = 5, [1] = 10
        exchange[0] = 1;
        for(int i = 1; i < bills.length; i++){
            if(bills[i] == 5){
                exchange[0] += 1;
                continue;
            }
            if(bills[i] == 10 && exchange[0] != 0){
                exchange[0] -= 1;
                exchange[1] += 1;
                continue;
            }
            if(bills[i] == 20 && exchange[0] != 0 && exchange[1] != 0){
                exchange[0] -= 1;
                exchange[1] -= 1;
                continue;
            }
            if(bills[i] == 20 && exchange[0] >= 3){
                exchange[0] -= 3;
                continue;
            }
            return false;
        }  
        return true;
    }
}