class Solution {
    public String longestCommonPrefix(String[] strs) {
         if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String firstword = strs[0];
        String lastword = strs[strs.length - 1];
        System.out.println(firstword);
        System.out.println(lastword);
        int i = 0;
        while (i < firstword.length() && i < lastword.length() && firstword.charAt(i) == lastword.charAt(i)) {
            i++;
        }

        return firstword.substring(0, i);
    }

}