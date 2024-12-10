class Solution {
    public int maximumLength(String s) {
        int res = 0;
        HashMap<String,Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sub = new StringBuilder();
            sub.append(s.charAt(i));
            for (int j = i + 1; j <= s.length(); j++) {
                freq.put(sub.toString(), freq.getOrDefault(sub.toString(), 0) + 1);
                if (j < s.length() && s.charAt(j) == s.charAt(j - 1)) {
                    sub.append(s.charAt(j)); 
                } else {
                    break; 
                }
            }
        }
        for (String str : freq.keySet()) {
            if (freq.get(str) >= 3 && str.length() > res){
                res = str.length();
            } 
        }
        return (res == 0)?-1:res;
    }   
}