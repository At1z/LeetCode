class Solution {
    public int countLargestGroup(int n) {
        int[] sumGroup = new int[37];
        for(int i = 1; i <= n; i++){
            int curSum = 0;
            int temp = i;
            while(temp > 0){
                curSum += temp%10;
                temp /= 10;
            }
            sumGroup[curSum-1] += 1;
        }
        int max = Arrays.stream(sumGroup).max().orElse(0);

        long frequency = Arrays.stream(sumGroup)
                            .filter(x -> x == max)
                            .count();

        return (int)frequency;
    }
}