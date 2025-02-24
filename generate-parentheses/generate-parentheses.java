class Solution {
    public List<String> generateParenthesis(int n) {
        int open = 0;
        int closed = 0;
        List<String> res = new ArrayList<>();
        backtracking(open, closed, new StringBuilder(), res, n);
        return res;
    }
    
    public void backtracking(int open, int closed, StringBuilder sb, List<String> res, int n){
        if(sb.length() == n*2){
            res.add(sb.toString());
            return;
        }
        if( open < n){
            sb.append('(');
            backtracking(open + 1, closed, sb, res, n);
            sb.deleteCharAt(sb.length()-1);
            
        }
        
        if(closed < open){
            sb.append(')');
            backtracking(open, closed + 1, sb, res, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}