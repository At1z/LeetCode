class Solution {

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<Pair<Integer, Integer>> monoStack = new ArrayList<>();
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        List<List<Pair<Integer, Integer>>> newQueries = new ArrayList<>(
            heights.length
        );

        for (int i = 0; i < heights.length; i++) {
            newQueries.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (heights[b] > heights[a] || a == b) {
                result[i] = b;
            } else {
                newQueries.get(b).add(new Pair<>(heights[a], i));
            }
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            int monoStackSize = monoStack.size();
            for (Pair<Integer, Integer> pair : newQueries.get(i)) {
                int position = search(pair.getKey(), monoStack);
                if (position < monoStackSize && position >= 0) {
                    result[pair.getValue()] = monoStack
                        .get(position)
                        .getValue();
                }
            }

            while (
                !monoStack.isEmpty() &&
                monoStack.get(monoStack.size() - 1).getKey() <= heights[i]
            ) {
                monoStack.remove(monoStack.size() - 1);
            }

            monoStack.add(new Pair<>(heights[i], i));
        }

        return result;
    }

    private int search(int height, List<Pair<Integer, Integer>> monoStack) {
        int left = 0;
        int right = monoStack.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (monoStack.get(mid).getKey() > height) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
// TLE 944/951
/*class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        int index = 0; 
        int n = heights.length;

        while (index < queries.length) {
            int a = Math.min(queries[index][0],queries[index][1]);
            int b = Math.max(queries[index][0],queries[index][1]);
            if (a == b) {
                res[index] = a; 
                index += 1; 
                continue;
            }
            boolean[] reachA = new boolean[n];
            for (int i = a; i < n; i++) {
                if (heights[a] < heights[i]) {
                    reachA[i] = true;
                }
            }
            for (int j = b; j < n; j++) {
                if (reachA[j] && heights[b] < heights[j] || reachA[b] == true) {
                    res[index] = j;
                    break;
                }
            }
            index += 1;
        }
        return res;
    }
}
*/