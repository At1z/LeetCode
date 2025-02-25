class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    int[][] visited = new int[board.length][board[0].length];
                    if(dfs(0,i,j,board,visited,word) == true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(int index, int row, int col, char[][] board, int[][] visited, String word){
        if(row < 0 ||
           row >= board.length || 
           col < 0 ||
           col >= board[0].length || 
           visited[row][col] == 1 || 
           board[row][col] != word.charAt(index)){
            return false;
        }
        if(index == word.length() - 1){
            return true;
        }
        
        visited[row][col] = 1;
        boolean found = dfs(index + 1, row + 1, col, board, visited, word) ||
                        dfs(index + 1, row - 1, col, board, visited, word) ||
                        dfs(index + 1, row, col + 1, board, visited, word) ||
                        dfs(index + 1, row, col - 1, board, visited, word);

        visited[row][col] = 0;
        
        return found;
    } 
}