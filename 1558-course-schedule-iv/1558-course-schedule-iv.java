class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reachable = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            reachable[prerequisite[0]][prerequisite[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    reachable[i][j] |= (reachable[i][k] && reachable[k][j]);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(reachable[query[0]][query[1]]);
        }
        return res;
    }
}
