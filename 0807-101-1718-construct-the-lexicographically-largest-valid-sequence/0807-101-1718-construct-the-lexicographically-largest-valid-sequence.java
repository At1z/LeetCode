class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        backtrack(res, used, 0, n);
        return res;
    }

    private boolean backtrack(int[] res, boolean[] used, int index, int n) {
        if (index == res.length) return true; 

        if (res[index] != 0) return backtrack(res, used, index + 1, n);

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue; 

            int secondPos = (num == 1) ? index : index + num; 

            if (secondPos < res.length && res[secondPos] == 0) {
                res[index] = num;
                res[secondPos] = num;
                used[num] = true;

                if (backtrack(res, used, index + 1, n)) return true; 

                res[index] = 0;
                res[secondPos] = 0;
                used[num] = false;
            }
        }
        return false;
        /* Almost there ;/
        if (n == 1) {
            return new int[]{1};
        }
        int[] res = new int[n * 2 - 1];
        List<Integer> memo = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i <= n; i++) {
            maxHeap.add(i);
        }

        int index = 0;
        while (!maxHeap.isEmpty()) {
            if (maxHeap.isEmpty()) {
                maxHeap.addAll(memo);
                memo.clear();
            }
            int curNum = maxHeap.poll();
            if (curNum == 1) {
                res[index] = 1;
                maxHeap.addAll(memo);
                memo.clear();
                index += 1;
                continue;
            }

            if (index + curNum < res.length && res[index] == 0 && res[index + curNum] == 0) {
                res[index] = curNum;
                res[index + curNum] = curNum;
                maxHeap.addAll(memo);
                memo.clear();
                index += 1;
            } else {
                memo.add(curNum);
            }
        }
        return res;
        */
    }
}
