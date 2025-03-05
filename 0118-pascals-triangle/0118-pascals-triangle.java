class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        if(numRows == 1){
            return res;
        }
        for(int i = 1; i < numRows; i++){
            List<Integer> last = res.get(i-1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for(int j = 1; j < last.size(); j++){
                cur.add(last.get(j-1) + last.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}