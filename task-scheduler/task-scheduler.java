import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }
        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;
        
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;
                if (count > 0) {
                    cooldownQueue.add(new int[]{count, time + n}); 
                }
            }

            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.add(cooldownQueue.poll()[0]);
            }
        }
        
        return time;
    }
}
