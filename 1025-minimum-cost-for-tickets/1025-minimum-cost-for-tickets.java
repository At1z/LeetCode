class Solution {
    HashSet<Integer> travelDays = new HashSet<>();

    private int calculate(int[] memo, int[] days, int[] costs, int current) {
        if (current > days[days.length - 1]) {
            return 0;
        }

        if (!travelDays.contains(current)) {
            return calculate(memo, days, costs, current + 1);
        }

        if (memo[current] != -1) {
            return memo[current];
        }

        int oneDayCost = costs[0] + calculate(memo, days, costs, current + 1);
        int sevenDayCost = costs[1] + calculate(memo, days, costs, current + 7);
        int thirtyDayCost = costs[2] + calculate(memo, days, costs, current + 30);

        return memo[current] = Math.min(oneDayCost, Math.min(sevenDayCost, thirtyDayCost));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int lastTravelDay = days[days.length - 1];
        int memo[] = new int[lastTravelDay + 1];
        Arrays.fill(memo, -1);

        for (int day : days) {
            travelDays.add(day);
        }

        return calculate(memo, days, costs, 1);
    }
}
