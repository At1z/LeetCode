class Solution {
    public int countUnguarded(int rows, int cols, int[][] guards, int[][] walls) {
        // grid:
        // unguarded == 0
        // guarded == 1
        // wall == 2
        // guard == 3
        int[][] grid = new int[rows][cols];
        int unguardedCells = 0;

        for(int[] wall : walls){
            grid[wall[0]][wall[1]] = 2;
        }
        for(int[] guard : guards){
            grid[guard[0]][guard[1]] = 3;
        }
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 3){
                    guardCells(row,col,grid);
                }
            }
        }

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 0){
                    unguardedCells += 1;
                }
            }
        }

        return unguardedCells;

    }

    private void guardCells(int row, int col, int[][] grid){
        // up
        for(int index = row + 1; index < grid.length; index++){
            if(grid[index][col] == 2 || grid[index][col] == 3){
                break;
            }
            grid[index][col] = 1;
        }
        //down
        for(int index = row - 1; index >= 0; index--){
            if(grid[index][col] == 2 || grid[index][col] == 3){
                break;
            }
            grid[index][col] = 1;
        }
        //left
        for(int index = col - 1; index >= 0; index--){
            if(grid[row][index] == 2 || grid[row][index] == 3){
                break;
            }
            grid[row][index] = 1;
        }
        //right
        for(int index = col + 1; index < grid[0].length; index++){
            if(grid[row][index] == 2 || grid[row][index] == 3){
                break;
            }
            grid[row][index] = 1;
        }
    }

}