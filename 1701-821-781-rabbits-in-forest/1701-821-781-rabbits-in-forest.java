class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> freqeuncyMap = new HashMap<>();
        int rabbits = 0;
        for(int ans : answers){
            freqeuncyMap.put(ans, freqeuncyMap.getOrDefault(ans,0) + 1);
        }
        for(int key : freqeuncyMap.keySet()){
            if(key == 0){
                rabbits += freqeuncyMap.get(key);
            }else{
                int currentFrequency = freqeuncyMap.get(key);
                rabbits += currentFrequency/(key+1) * (key + 1);
                if(currentFrequency % (key+1) != 0){
                    rabbits += key + 1;
                } 
            }
        }
        return rabbits;
    }
}