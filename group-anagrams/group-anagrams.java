class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr); // Sorting takes O(K log K), where K is the max length of a string
            String key = new String(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
      
        
        /*
        List<List<String>> res = new ArrayList<>();
        int[] set = new int[strs.length];
        for(int i = 0; i < strs.length; i++){
            if(set[i] == 1){
                continue;
            }
            List<String> cur = new ArrayList<>();
            cur.add(strs[i]); // cur = ["eat"];
            set[i] = 1; // set = [1,0,0,0 ...]
            int[] freq = new int[26]; // tab for freq
            for(int j = 0; j < strs[i].length(); j++){
                freq[strs[i].charAt(j) - 'a'] += 1;
            }
            for(int z = i + 1; z < strs.length; z++){
                if(set[z] == 1){
                    continue;
                }
                int[] freq2 = new int[26]; // tab for freq2
                for(int k = 0; k < strs[z].length(); k++){
                    freq2[strs[z].charAt(k) - 'a'] += 1;
                }
                boolean same = true;
                for(int o = 0; o < freq.length; o++){
                    if(freq[o] != freq2[o]){
                        same = false;
                        break;
                    }
                }
                if(same){
                    cur.add(strs[z]);
                    set[z] = 1;
                }
            }
            res.add(cur);
        }
        return res;
    
    */
    }
}