class Solution {
    public int countDays(int days, int[][] meetings) {
        //List<int[]> mergedMeetings = new ArrayList<>();
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        /*
        for(int[] meeting: meetings){
            System.out.println(Arrays.toString(meeting));
        }
        */
        int start = meetings[0][0];
        int end = meetings[0][1];
        for(int i = 1; i < meetings.length; i++){
            int curStart = meetings[i][0];
            int curEnd = meetings[i][1];
            if(curStart <= end){
                if(curEnd > end){
                    end = curEnd;
                }
            }else{
                days -= end - start + 1;
                //mergedMeetings.add(new int[]{start,end});
                start = curStart;
                end = curEnd;
            }
        }
        days -= end - start + 1;
        //mergedMeetings.add(new int[]{start,end});
        /*
        for(int[] meeting: mergedMeetings){
            System.out.println(Arrays.toString(meeting));
        }
        for(int i = 0; i < mergedMeetings.size(); i++){
            int curSubstract = mergedMeetings.get(i)[1] - mergedMeetings.get(i)[0] + 1;
            days -= curSubstract;
        }
        */
        return days;
    }
}