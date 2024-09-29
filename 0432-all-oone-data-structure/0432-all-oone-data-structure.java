class AllOne {
    private HashMap<String, Integer> countMap; 
    private HashMap<Integer, HashSet<String>> keysByCount; 
    private int maxCount; 
    private int minCount; 

    public AllOne() {
        countMap = new HashMap<>();
        keysByCount = new HashMap<>();
        maxCount = 0;
        minCount = 0; 
    }

    public void inc(String key) {
        int count = countMap.getOrDefault(key, 0);
        countMap.put(key, count + 1);
        
        if (count > 0) {
            keysByCount.get(count).remove(key);
            if (keysByCount.get(count).isEmpty()) {
                keysByCount.remove(count);
                if (count == minCount) {
                    updateMinCount();
                }
            }
        }
        
        int newCount = count + 1;
        keysByCount.computeIfAbsent(newCount, k -> new HashSet<>()).add(key);
        
        maxCount = Math.max(maxCount, newCount);
        if (minCount == 0 || newCount < minCount) {
            minCount = newCount;
        }
    }

    public void dec(String key) {
        int count = countMap.get(key);
        if (count == 1) {
            countMap.remove(key);
            keysByCount.get(1).remove(key);
            if (keysByCount.get(1).isEmpty()) {
                keysByCount.remove(1);
            }
            updateMinCount();
        } else {
            countMap.put(key, count - 1);
            keysByCount.get(count).remove(key);
            if (keysByCount.get(count).isEmpty()) {
                keysByCount.remove(count);
                if (count == maxCount) {
                    maxCount--;
                }
            }
            keysByCount.computeIfAbsent(count - 1, k -> new HashSet<>()).add(key);
            updateMinCount();
        }
    }

    private void updateMinCount() {
        minCount = Integer.MAX_VALUE;
        for (int cnt : keysByCount.keySet()) {
            if (cnt < minCount) {
                minCount = cnt;
            }
        }
        if (minCount == Integer.MAX_VALUE) {
            minCount = 0;  
        }
    }

    public String getMaxKey() {
        if (maxCount == 0) return "";
        for (String key : keysByCount.get(maxCount)) {
            return key; 
        }
        return "";
    }

    public String getMinKey() {
        if (minCount == 0) return "";
        for (String key : keysByCount.get(minCount)) {
            return key; 
        }
        return "";
    }
}
