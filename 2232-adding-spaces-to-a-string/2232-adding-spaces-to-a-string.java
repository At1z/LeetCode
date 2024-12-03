class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int spacesIndex = 0;
        for(int i = 0; i < s.length(); i++){
            if(spacesIndex < spaces.length && spaces[spacesIndex] == i){
                sb.append(" ");
                spacesIndex += 1;
            }
            sb.append(c[i]);
        }
        return sb.toString();
    }
}