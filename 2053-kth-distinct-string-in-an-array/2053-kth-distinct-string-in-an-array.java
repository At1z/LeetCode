import java.util.HashMap;
import java.util.Map;
class Solution {
    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> distinctMap = new HashMap<>();
        for (String s : arr) {
            distinctMap.put(s, distinctMap.getOrDefault(s, 0) + 1);
        }
        
        int distinctCount = 0;
        for (String s : arr) {
            if (distinctMap.get(s) == 1) {
                distinctCount++;
                if (distinctCount == k) {
                    return s;
                }
            }
        }  
        return "";
    }
}