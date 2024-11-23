class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;
        char[][] rBox = new char[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                rBox[i][j] = '.'; 
            }
        }
        for(int i = rows-1; i >= 0; i--){
            int rRows = cols;
            for(int j = cols-1; j >= 0; j--){
                if(box[i][j] == '#'){
                    rBox[rRows-1][rows - 1 - i] = box[i][j];
                    rRows -= 1;
                }
                if(box[i][j] == '*'){
                    rBox[j][rows - 1 - i] = box[i][j];
                    rRows = j;
                }         
            }
        }
        return rBox;
    }
}