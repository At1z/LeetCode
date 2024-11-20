class Solution {
    public int takeCharacters(String s, int k) {
         int[] count = new int[3];
        int n = s.length();

        // Count total occurrences
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if we have enough characters
        for (int i = 0; i < 3; i++) {
            if (count[i] < k) return -1;
        }

        int[] window = new int[3];
        int left = 0, maxWindow = 0;

        // Find the longest window that leaves k of each character outside
        for (int right = 0; right < n; right++) {
            window[s.charAt(right) - 'a']++;

            // Shrink window if we take too many characters
            while (
                left <= right &&
                (count[0] - window[0] < k ||
                    count[1] - window[1] < k ||
                    count[2] - window[2] < k)
            ) {
                window[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    /* TLE
        int n = s.length();
        if (n < k) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int left = 0; left < n; left++) {
            int[] counts = {k, k, k};
            int cLeft = 0;
            int right = n - 1;
            while ((counts[0] > 0 || counts[1] > 0 || counts[2] > 0) && right >= left) {
                while (cLeft < left) {
                    if (s.charAt(cLeft) == 'a') {
                        counts[0] -= 1;
                    } else if (s.charAt(cLeft) == 'b') {
                        counts[1] -= 1;
                    } else if (s.charAt(cLeft) == 'c') {
                        counts[2] -= 1;
                    }
                    cLeft++;
                }
                if (counts[0] <= 0 && counts[1] <= 0 && counts[2] <= 0) {
                    res = Math.min(res, left);
                }
                if (s.charAt(right) == 'a') {
                    counts[0] -= 1;
                } else if (s.charAt(right) == 'b') {
                    counts[1] -= 1;
                } else if (s.charAt(right) == 'c') {
                    counts[2] -= 1;
                }
                right -= 1;
            }
            if (counts[0] <= 0 && counts[1] <= 0 && counts[2] <= 0) {
                res = Math.min(res, left + (n - 1 - right));
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
        */
    }
}
