import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minimumPushes(String word) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i + 1);
            frequencyMap.put(letter, frequencyMap.getOrDefault(letter, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        int letterCounter = 1;
        int padPush = 1;
        int totalPushes = 0;
        HashMap<String, Integer> keypads = new HashMap<>();

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            String letter = entry.getKey();
            keypads.put(letter, padPush);
            letterCounter++;
            if (letterCounter == 9) { 
                padPush++;
                letterCounter = 1;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i + 1);
            totalPushes += keypads.get(letter);
        }

        for (String letter : keypads.keySet()) {
            System.out.println(letter + ": " + keypads.get(letter));
        }

        return totalPushes;
    }
}