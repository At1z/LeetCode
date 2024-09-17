class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> n1 = new HashSet<Integer>();
        HashSet<Integer> n2 = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++){
            n1.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            n2.add(nums2[i]);
        }
        n1.retainAll(n2);
        int[] res = new int[n1.size()];
        int idx = 0;
        for (Integer i : n1) {
                res[idx++] = i; 
        }
       
    return res;
    }
}