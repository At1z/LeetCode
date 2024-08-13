class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates); 
        backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> combination, int[] candidates, int target, int start) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));  
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; 

            combination.add(candidates[i]);
            backtrack(results, combination, candidates, target - candidates[i], i + 1); 
            combination.remove(combination.size() - 1); 
        }
    }

}