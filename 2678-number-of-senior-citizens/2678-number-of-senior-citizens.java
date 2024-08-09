class Solution {
    public int countSeniors(String[] details) {
        int counter = 0;
        int age = 0;
        for(int i = 0; i < details.length; i++ ){
            age = Integer.valueOf(details[i].substring(11,13));
            if (age > 60){
                counter++;
            }
        }
    return counter;
    }
}