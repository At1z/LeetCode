class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
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
    }
}