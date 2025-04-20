class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> mapOfIndex = new HashMap<>();
        List<List<Integer>> groups = new ArrayList<>();
        for(int num = 0; num < groupSizes.length; num++){
            mapOfIndex.putIfAbsent(groupSizes[num],new ArrayList<>());
            mapOfIndex.get(groupSizes[num]).add(num);
        }
        for(int key : mapOfIndex.keySet()){
            List<Integer> curGroup = mapOfIndex.get(key);
            List<Integer> groupOfKeySize = new ArrayList<>();
            for(int index = 1; index <= curGroup.size(); index++){
                groupOfKeySize.add(curGroup.get(index-1));
                if(index % key == 0){
                    groups.add(new ArrayList<>(groupOfKeySize));
                    groupOfKeySize.clear();
                } 
            }
            if(curGroup.size() % key != 0){
                groups.add(new ArrayList<>(groupOfKeySize));
            }
        }
        return groups;
    }
}