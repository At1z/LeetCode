class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
                if( n == 0 ){
            return res;
        }
        int[] arrsort = new int [n];
        int index = 0;
        for(int i : arr){
            arrsort[index] = i;
            index += 1;
        }
        Arrays.sort(arrsort);
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        temp.put(arrsort[0],1);
        int curVal = 1;
        for(int i = 1; i < n; i++){
            if(arrsort[i-1] != arrsort[i]){
                curVal += 1;
            }
            temp.put(arrsort[i],curVal);
        }
        index = 0;
        for (int key : arr) {
            if (temp.containsKey(key)) {
                res[index] = temp.get(key);  
            } else {
                res[index] = -1; 
            }
            index += 1;
        }
    return res;
    }
}