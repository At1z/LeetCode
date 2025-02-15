class Solution {
    public int punishmentNumber(int n) {
        List<Integer> nums = new ArrayList<>();
        int res = 1;
        int num = 9;
        while(num <= n){
            nums.add(num);
            if(num + 1 <= n){
                nums.add(num+1);
            }
            num += 9;
        }
        for(int i = 0; i < nums.size(); i++){
            int curNum = nums.get(i) * nums.get(i);
            String stringNum = Integer.toString(curNum);
            if(canSplit(nums.get(i), stringNum)){
                res += curNum;
            }
        }
        return res;
    }

    public boolean canSplit(int target, String stringNum){
        if(target == 0 && stringNum.isEmpty()){
            return true;
        }
        if(target < 0){
            return false;
        }

        for(int j = 0; j < stringNum.length(); j++){
            int firstHalf = Integer.parseInt(stringNum.substring(0,j+1));
            String secondHalf = stringNum.substring(j+1);
            if(canSplit(target - firstHalf, secondHalf)){
                return true;
            }
        }
        return false;
    }
}