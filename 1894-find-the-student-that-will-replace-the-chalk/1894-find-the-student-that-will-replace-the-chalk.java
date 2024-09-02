class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int size = chalk.length;
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        k = (int)(k % sum);
        for (int i = 0; i < size; i++) {
            k -= chalk[i];
            if (k < 0) {
                return i;
            }
        }
        return -1;
    }
}
