public class Solution {
    public long mostPoints(int[][] questions) {
        Map<Integer, Long> memo = new HashMap<>();
        return solve(questions, 0, memo);
    }

    public long solve(int[][] questions, int index, Map<Integer, Long> memo) {
        if (index >= questions.length) {
            return 0;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        } 
        int[] curQuestion = questions[index];
        long take = curQuestion[0] + solve(questions, index + curQuestion[1] + 1, memo);
        long skip = solve(questions, index + 1, memo);
        
        long result = Math.max(take, skip);
        memo.put(index, result);
        return result;
    }
}
