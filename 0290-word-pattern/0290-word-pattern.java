class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            char curPatern = pattern.charAt(i);
            map.putIfAbsent(curPatern, words[i]);
            if(!words[i].equals(map.get(curPatern))){
                return false;
            }
        }
        Set<String> seen = new HashSet<>();
        for(String curString: map.values()){
            if(seen.contains(curString)){
                return false;
            }else{
                seen.add(curString);
            }
        }
        return true;
    }
}
/*
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char curS = s.charAt(i);
            map.putIfAbsent(curS, t.charAt(i));
            if(t.charAt(i) != map.get(curS)){
                return false;
            }
        }
        Set<Character> seen = new HashSet<>();
        for(char c: map.values()){
            if(seen.contains(c)){
                return false;
            }else{
                seen.add(c);
            }
        }
        return true;
    }
}
*/