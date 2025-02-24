class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        Map<Character, List<Character>> keypad = new HashMap<>();
        keypad.put('2', Arrays.asList('a', 'b', 'c'));
        keypad.put('3', Arrays.asList('d', 'e', 'f'));
        keypad.put('4', Arrays.asList('g', 'h', 'i'));
        keypad.put('5', Arrays.asList('j', 'k', 'l'));
        keypad.put('6', Arrays.asList('m', 'n', 'o'));
        keypad.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keypad.put('8', Arrays.asList('t', 'u', 'v'));
        keypad.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        List<String> res = new ArrayList<>();
        permutations(digits, keypad, res, 0, new StringBuilder());
        return res;
    }
    
    public void permutations(String digits, Map<Character, List<Character>> keypad, List<String> res,int index, StringBuilder cur ){
        if(index == digits.length()){
            res.add(cur.toString());
            return;
        }
        List<Character> keys = keypad.get(digits.charAt(index));
        for(int i = 0; i < keys.size(); i++){
            cur.append(keys.get(i));
            permutations(digits, keypad, res, index + 1, cur);
            cur.deleteCharAt(cur.length() - 1); 
        }
    }
}