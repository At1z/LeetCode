class MyCalendarTwo {
    private ArrayList<int[]> calendar;

    public MyCalendarTwo() {
        
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        ArrayList<int[]> overlaps = new ArrayList<>();
        for (int[] event : calendar) {
            int bookedStart = event[0];
            int bookedEnd = event[1];
            int overlapCount = event[2];

            if (start < bookedEnd && end > bookedStart) {
                if (overlapCount >= 2) {
                    return false;
                }
                overlaps.add(new int[] {
                    Math.max(start, bookedStart),  
                    Math.min(end, bookedEnd),      
                    overlapCount + 1               
                });
            }
        }
        calendar.add(new int[] {start, end, 1});  
        for (int[] overlap : overlaps) {
            calendar.add(overlap);  
        }
        /* Keep track of Array :)
        for (int[] event : calendar) {
            System.out.print(Arrays.toString(event)); 
        }
        System.out.println();
        */
        return true; 
    }
}