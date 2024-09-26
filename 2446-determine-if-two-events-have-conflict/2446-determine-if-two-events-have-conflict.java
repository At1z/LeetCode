class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int h1 = Integer.parseInt(event1[0].substring(0,2))*60;
        int m1 =  Integer.parseInt(event1[0].substring(3,5));
        int rangeStart = h1 + m1;
        int h2 = Integer.parseInt(event1[1].substring(0,2))*60;
        int m2 =  Integer.parseInt(event1[1].substring(3,5));
        int rangeEnd = h2 + m2;
        int h3 = Integer.parseInt(event2[0].substring(0,2))*60;
        int m3 =  Integer.parseInt(event2[0].substring(3,5));
        int start = h3 + m3;
        int h4 = Integer.parseInt(event2[1].substring(0,2))*60;
        int m4 =  Integer.parseInt(event2[1].substring(3,5));
        int end = h4 + m4;
        return (rangeStart <= end && rangeEnd >= start);
    }
}