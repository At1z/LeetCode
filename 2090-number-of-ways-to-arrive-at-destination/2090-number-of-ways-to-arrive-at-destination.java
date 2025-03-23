class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new Pair(v, time));
            graph.get(v).add(new Pair(u, time));
        }

        long[] dist = new long[n], ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.time));
        pq.offer(new Pair(0, 0));

        final int MOD = 1_000_000_007;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            long time = curr.time;

            if (time > dist[node]) continue;

            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                long nextTime = time + neighbor.time;

                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new Pair(nextNode, nextTime));
                } else if (nextTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }

    private static class Pair {
        int node;
        long time;

        public Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }
}
