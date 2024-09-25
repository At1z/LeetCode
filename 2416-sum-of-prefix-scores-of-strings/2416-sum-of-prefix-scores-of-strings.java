class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; 
        int count = 0;  
    }

    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.count++;  
            }
        }

        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            int sum = 0;
            for (char c : words[i].toCharArray()) {
                int index = c - 'a';
                node = node.children[index];
                sum += node.count;  
            }
            res[i] = sum;
        }

        return res;
    }
}
/*class Solution {
    public int[] sumPrefixScores(String[] words) {
        int [] res = new int[words.length];
        for(int i = 0; i < words.length; i++){
            Set<String> wordsPrefix = new HashSet<String>();
            for(int j = 1; j < words[i].length()+1; j++){
                wordsPrefix.add(words[i].substring(0,j));
            }
            for(int j = 0; j < words.length; j++){
                for(int z = 1; z < words[j].length()+1; z++){
                    if(wordsPrefix.contains(words[j].substring(0,z))){
                        res[i] += 1;
                    }else{
                        break;
                    }
                }
            }

        }
      return res;  
    }
}
*/