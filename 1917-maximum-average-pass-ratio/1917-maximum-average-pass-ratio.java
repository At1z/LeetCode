class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(gain(b[0], b[1]), gain(a[0], a[1]))
        );
        for (int[] c : classes) {
            pq.offer(c);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] cls = pq.poll();
            cls[0]++; 
            cls[1]++; 
            pq.offer(cls); 
        }
        double totalAverage = 0.0;
        while (!pq.isEmpty()) {
            int[] cls = pq.poll();
            totalAverage += (double) cls[0] / cls[1];
        }
        return totalAverage / classes.length;

    }    private double gain(int passed, int total) {
        double currentRatio = (double) passed / total;
        double newRatio = (double) (passed + 1) / (total + 1);
        return newRatio - currentRatio;
    }

}