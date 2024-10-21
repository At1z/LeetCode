public class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }
    private int backtrack(String s, int start, Set<String> seen) {
        if (start == s.length()) {
            return 0;
        }
        int res = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            String currSubstring = s.substring(start, i);
            if (!seen.contains(currSubstring)) {
                seen.add(currSubstring);  
                int count = 1 + backtrack(s, i, seen);
                res = Math.max(res, count);
                seen.remove(currSubstring); 
            }
        }
        return res;
    }
}