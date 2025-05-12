class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] used = new int[digits.length];
        Set<Integer> resultSet = new HashSet<>();
        backtracking(0, new int[3], digits, resultSet, used);
        List<Integer> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void backtracking(int index, int[] curNumber, int[] digits, Set<Integer> resultSet,int[] used){
        if(index == 3 && curNumber[0] != 0){
            if(curNumber[2] % 2 == 0){
                resultSet.add(curNumber[0] * 100 + curNumber[1] * 10 + curNumber[2]);
            }
        }
        if(index > 2){
            return;
        }
        for(int i = 0; i < digits.length; i++){
            if(used[i] == 1){
                continue;
            }
            curNumber[index] = digits[i];
            used[i] = 1;
            backtracking(index + 1, curNumber, digits, resultSet, used);
            curNumber[index] = -1;
            used[i] = 0;
        }
    }
}