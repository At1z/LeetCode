class Solution {
    public void gameOfLife(int[][] board) {
        int [][] copyBoard = new int[board.length][board[0].length];
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                int count = findNeigbours(row,col,board);
                if(board[row][col] == 1 && (count == 2 || count == 3)){
                    copyBoard[row][col] = 1;
                }else if(board[row][col] == 0 && count == 3){
                    copyBoard[row][col] = 1;
                }
            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = copyBoard[row][col];
            }
        }
    }
    private int findNeigbours(int row, int col, int[][] board) {
        int count = 0;
        int rows = board.length;
        int cols = board[0].length;

        // Kierunki dla 8 sąsiadów: góra, dół, lewo, prawo i 4 przekątne
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            // Sprawdzenie granic planszy
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                if (board[newRow][newCol] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}