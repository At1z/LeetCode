class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = arr.length;
        int[] forces = new int[n];

        int force = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                force = n;
            } else if (arr[i] == 'L') {
                force = 0;
            } else if (force > 0) {
                force--;
            }
            forces[i] += force;
        }

        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') {
                force = n;
            } else if (arr[i] == 'R') {
                force = 0;
            } else if (force > 0) {
                force--;
            }
            forces[i] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for (int f : forces) {
            if (f > 0) sb.append('R');
            else if (f < 0) sb.append('L');
            else sb.append('.');
        }

        return sb.toString();
    }
}
