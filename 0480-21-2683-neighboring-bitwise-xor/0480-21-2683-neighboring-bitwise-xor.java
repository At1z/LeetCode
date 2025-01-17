class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        boolean[] scenario1 = reconstruct(derived, 0);
        boolean[] scenario2 = reconstruct(derived, 1);
        return scenario1[0] || scenario2[0];
    }

    private static boolean[] reconstruct(int[] derived, int start) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = start;
        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = original[i] ^ derived[i];
        }
        boolean valid = (original[n - 1] ^ original[0]) == derived[n - 1];
        return new boolean[] { valid, original[0] == 0 };
    }
}