class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> res = new HashMap();
        for (String str: s1.split(" "))
            res.put(str, res.getOrDefault(str, 0) + 1);
        for (String str: s2.split(" "))
            res.put(str, res.getOrDefault(str, 0) + 1);

        List<String> result = new ArrayList<String>();
        for (String str: res.keySet())
            if (res.get(str) == 1)
                result.add(str);

        return result.toArray(new String[result.size()]);
    }
}