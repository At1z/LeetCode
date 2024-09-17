class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> w1 = new HashMap<String,Integer>();
        HashMap<String, Integer> w2 = new HashMap<String,Integer>();
        HashMap<String, Integer> res = new HashMap<String,Integer>();
        int result = 0;
        for(String str1 : words1){
            w1.put(str1, w1.getOrDefault(str1, 0) + 1);
        }
        for(String str2 : words2){
            w2.put(str2, w2.getOrDefault(str2, 0) + 1);
        }
        for (String str1: w1.keySet()){
            if (w1.get(str1) == 1)
                res.put(str1, res.getOrDefault(str1, 0) + 1);
        }
        for (String str2: w2.keySet()){
            if (w2.get(str2) == 1)
                res.put(str2, res.getOrDefault(str2, 0) + 1);
        }

        for (String str: res.keySet())
            if (res.get(str) == 2)
                result += 1;

    return result;
    }
}