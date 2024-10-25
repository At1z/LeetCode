class Solution {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        System.out.println(Arrays.toString(folder));
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String lastFolder = res.get(res.size() - 1);
            lastFolder += '/';
            if (!folder[i].startsWith(lastFolder)) {
                res.add(folder[i]);
            }
        }
        return res;
    }
}