class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<String> vowelWords = new HashSet<>();
        for (String s : words) {
            if (vowel.contains(s.charAt(0)) && vowel.contains(s.charAt(s.length() - 1))) {
                vowelWords.add(s);
            }
        }
        int[] prefixSum = new int[words.length];
        prefixSum[0] = vowelWords.contains(words[0]) ? 1 : 0;
        for (int i = 1; i < words.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (vowelWords.contains(words[i]) ? 1 : 0);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            res[i] = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0);
        }
        
        return res;
    }
}
