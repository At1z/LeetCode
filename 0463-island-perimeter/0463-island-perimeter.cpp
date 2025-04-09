class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        int perimeter = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 1) {  
                    
                    // Check above (row - 1, col)
                    if (i == 0 || grid[i - 1][j] == 0) {
                        perimeter++;
                    }
                    // Check below (row + 1, col)
                    if (i == rows - 1 || grid[i + 1][j] == 0) {
                        perimeter++;
                    }
                    // Check left (row, col - 1)
                    if (j == 0 || grid[i][j - 1] == 0) {
                        perimeter++;
                    }
                    // Check right (row, col + 1)
                    if (j == cols - 1 || grid[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }
};
