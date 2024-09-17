class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> w1 = new HashMap<String,Integer>();
        HashMap<String, Integer> w2 = new HashMap<String,Integer>();
        int result = 0;
        for(String str1 : words1){
            w1.put(str1, w1.getOrDefault(str1, 0) + 1);
        }
        for(String str2 : words2){
            w2.put(str2, w2.getOrDefault(str2, 0) + 1);
        }
        for(String str : w1.keySet()) {
            if(w2.containsKey(str) && w2.get(str) == 1 && w1.get(str) == 1) {
                result += 1;
            }
        }

    return result;
    }
}