class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[][] matrix = new int[rows][cols];
        
        int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int directionIndex = 0; 
        int steps = 1; 
        int count = 0; 
        int x = rStart, y = cStart;

        result[count++] = new int[] {x, y};
        matrix[x][y] = 1;
        
        while (count < rows * cols) {
            for (int i = 0; i < steps; i++) {
                if (count >= rows * cols) break;
  
                x += directions[directionIndex][0];
                y += directions[directionIndex][1];

                if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] == 0) {
                    matrix[x][y] = 1;
                    result[count++] = new int[] {x, y};
                }
            }

            directionIndex = (directionIndex + 1) % 4;

            if (directionIndex % 2 == 0) {
                steps++;
            }
        }
        
        return result;
    }
}
