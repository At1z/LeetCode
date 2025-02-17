class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> seen = new HashSet<>();
        backtrack(tiles.toCharArray(), new boolean[tiles.length()], new StringBuilder(), seen);
        return seen.size();
    }
    
    private void backtrack(char[] tiles, boolean[] used, StringBuilder current, Set<String> seen) {
        for (int i = 0; i < tiles.length; i++) {
            if (used[i]) continue;
            if (i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1]) continue;
            
            used[i] = true;
            current.append(tiles[i]);
            seen.add(current.toString());
            backtrack(tiles, used, current, seen);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}
