class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> doubles = new HashMap<>();
        for(int num:arr){
            doubles.put(num,doubles.getOrDefault(num, 0)+1);
        }
        for(int num:doubles.keySet()){
            if(doubles.containsKey(num*2)){
                if(num == 0 && doubles.get(0) < 2){
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}