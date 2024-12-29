
public class Solution {

    public int numWays(String[] words, String target) {
        int n = words[0].length();
        int m = target.length();

        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        int[][] freq = new int[n][26];

        for (String word : words) {
            for (int j = 0; j < n; j++) {
                int charIdx = word.charAt(j) - 'a';
                freq[j][charIdx]++;
            }
        }

        return (int) findWays(words, target, 0, 0, memo, freq);
    }

    private long findWays(
        String[] words,
        String target,
        int wordPos,
        int targetPos,
        int[][] memo,
        int[][] freq
    ) {
        int MOD = 1000000007;

        if (targetPos == target.length()) return 1;

        if (wordPos == words[0].length() || words[0].length() - wordPos < target.length() - targetPos) 
            return 0;

        if (memo[wordPos][targetPos] != -1) return memo[wordPos][targetPos];

        long ways = 0;
        int targetChar = target.charAt(targetPos) - 'a';

        ways += findWays(words, target, wordPos + 1, targetPos, memo, freq);

        ways += freq[wordPos][targetChar] * findWays(words, target, wordPos + 1, targetPos + 1, memo, freq);

        memo[wordPos][targetPos] = (int) (ways % MOD);

        return memo[wordPos][targetPos];
    }
}
