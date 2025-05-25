class Solution {
    public int longestPalindrome(String[] words) {
        /*
        Set<Integer> pairSet = new HashSet<>();
        int pairs = 0;
        int single = 0;
        for(int i = 0; i < words.length; i++){
            if(pairSet.contains(i)){
                continue;
            }
            boolean donthasPair = true;
            pairSet.add(i);
            for(int j = i + 1; j < words.length; j++){
                if(pairSet.contains(j)){
                    continue;
                }
                if(words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)){
                    pairSet.add(j);
                    donthasPair = false;
                    pairs += 1;
                    break;
                }
            }
            if(donthasPair && words[i].charAt(0) == words[i].charAt(1)){
                single += 1;
            }
        }
        if(single > 0){
            return pairs * 4 + 2;
        }
        return pairs * 4;
        */
    Set<String> pairSet = new HashSet<>();
    HashMap<String, Integer> frequency = new HashMap<>();
    int res = 0;
    boolean hasMiddle = false;
    for (String word : words) {
        frequency.put(word, frequency.getOrDefault(word, 0) + 1);
    }

    for (String key : frequency.keySet()) {
        String reversedKey = new StringBuilder()
                                .append(key.charAt(1))
                                .append(key.charAt(0))
                                .toString();

        if (key.equals(reversedKey)) {
            int count = frequency.get(key);
            res += (count / 2) * 2; 
            if (count % 2 == 1) {
                hasMiddle = true; 
            }
        }
        else if (!pairSet.contains(reversedKey)) {
            int count1 = frequency.getOrDefault(key, 0);
            int count2 = frequency.getOrDefault(reversedKey, 0);
            res += 2 * Math.min(count1, count2); 
        }

        pairSet.add(key); 
    }

    if (hasMiddle) {
        res += 1; 
    }

    return res*2; 
    }
}