class Solution {
    public int findMinDifference(List<String> timePoints) {
        int res = 24*60;
        int [] timePointsInMinutes = new int[timePoints.size()];
        for(int i = 0; i < timePointsInMinutes.length; i++){
            String points = timePoints.get(i);
            int hours = Integer.parseInt(points.substring(0, 2));
            int minutes = Integer.parseInt(points.substring(3));
            timePointsInMinutes[i] = hours * 60 + minutes;
        }
        Arrays.sort(timePointsInMinutes);
        res = Math.min(res,24 * 60 - timePointsInMinutes[timePointsInMinutes.length-1] + timePointsInMinutes[0]);
        for(int i = 0; i < timePointsInMinutes.length-1; i++){
            res = Math.min(res,timePointsInMinutes[i+1] - timePointsInMinutes[i]);
        }
        return res;
        /*
        int hours = 0;
        int minutes = 0;
        int res = 24 * 60;

        for (int i = 0; i < timePoints.size(); i++) {
            String[] currTimePoint = timePoints.get(i).split(":");
            int currTimeInMinutes = Integer.parseInt(currTimePoint[0]) * 60 + Integer.parseInt(currTimePoint[1]);

            for (int j = i + 1; j < timePoints.size(); j++) {
                String[] currTimePointNext = timePoints.get(j).split(":");
                int nextTimeInMinutes = Integer.parseInt(currTimePointNext[0]) * 60 + Integer.parseInt(currTimePointNext[1]);

                int diff = Math.abs(currTimeInMinutes - nextTimeInMinutes);

                res = Math.min(res, Math.min(diff, 1440 - diff));
            }
        }

        return res;
        */
    }
}
