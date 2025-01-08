class Solution {

    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (words[i].length() > words[j].length()) continue;
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    res += 1;
                }
            }
        }
        return res;
    }
}