class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        HashMap<Character,Integer> freq = new HashMap<>();
        int res = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            freq.put(c,freq.getOrDefault(c,0) + 1);

            while(freq.get(c) > 1){
                freq.put(s.charAt(l), freq.get(s.charAt(l)) -1);
                l += 1;
            }
            res = Math.max(res, r - l + 1);
            r += 1;
        }
        return res;
    }
}