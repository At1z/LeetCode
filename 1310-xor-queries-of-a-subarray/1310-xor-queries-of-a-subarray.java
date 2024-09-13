class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int [] res = new int[queries.length];

        for(int i = 0; i < queries.length; i++ ){
            int start = queries[i][0];
            int end = queries[i][1];
            int currres = 0;
            currres = arr[start];
            for(int j = start + 1; j <= end; j++){
                currres = currres ^ arr[j];
            }
            res[i] = currres;
        }

        return res;
    }
}