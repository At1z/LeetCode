class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for(int a:arr){
            freq.put(a,freq.getOrDefault(a,0) + 1);
        }
        Set<Integer> rep = new HashSet<>();
        for (Integer key : freq.keySet()) {
            if(rep.contains(freq.get(key))){
                return false;
            }else{
                rep.add(freq.get(key));
            }
        }
        return true;
    }
}