class Solution {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            // Check if 2 * num or num / 2 exists in the set
            if (
                seen.contains(2 * num) ||
                (num % 2 == 0 && seen.contains(num / 2))
            ) {
                return true;
            }
            // Add the current number to the set
            seen.add(num);
        }
        // No valid pair found
        return false;
    }
}