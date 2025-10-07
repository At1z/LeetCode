class Solution {
    public int[] avoidFlood(int[] rains) {
        int size = rains.length;
        int[] res = new int[size];
        Arrays.fill(res, 1);
        Map<Integer, Integer> seen = new HashMap<>();
        List<Integer> dry = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (rains[i] > 0) { 
                if (seen.containsKey(rains[i])) {
                    int index = -1;
                    for (int j = 0; j < dry.size(); j++) {
                        if (dry.get(j) > seen.get(rains[i])) {
                            index = j;
                            break;
                        }
                    }
                    if (index == -1) {
                        return new int[0]; 
                    }
                    res[dry.get(index)] = rains[i];
                    dry.remove(index);
                    seen.put(rains[i], i);
                    res[i] = -1;
                } else {
                    res[i] = -1;
                    seen.put(rains[i], i);
                }
            } else { 
                dry.add(i);
            }
        }

        return res;
    }
}
