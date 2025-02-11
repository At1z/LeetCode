class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            for(int i = 0; i <= s.length() - part.length(); i++){
                if(s.substring(i, i + part.length()).equals(part)){
                    s = s.substring(0, i) + s.substring(i + part.length(), s.length());
                    break;
                }
            }
        }
        return s;
    }
}