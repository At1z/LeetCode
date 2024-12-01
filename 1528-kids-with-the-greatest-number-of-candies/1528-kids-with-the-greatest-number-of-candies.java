class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<Boolean>();
        int maxCandies = 0;
        for(int candie:candies){
           maxCandies = Math.max(maxCandies,candie);
        }
        for(int i:candies){
            if(i + extraCandies >= maxCandies){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;
    }
}