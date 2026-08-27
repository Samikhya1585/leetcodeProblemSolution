class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // Try making the first difference at position i.
        // Right to left gives the smallest possible answer.
        for (int i = n - 1; i >= 0; i--) {

            // Count all characters in s
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Use the prefix target[0...i-1]
            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';

                if (count[x] == 0) {
                    possible = false;
                    break;
                }

                count[x]--;
            }

            // If target's prefix cannot be formed, try another i
            if (!possible) {
                continue;
            }

            int cur = target.charAt(i) - 'a';

            // Find the smallest character greater than target[i]
            for (int c = cur + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // 1. Same prefix as target
                    for (int j = 0; j < i; j++) {
                        ans.append(target.charAt(j));
                    }

                    // 2. First character greater than target[i]
                    ans.append((char) ('a' + c));

                    count[c]--;

                    // 3. Put remaining characters in sorted order
                    for (int x = 0; x < 26; x++) {
                        while (count[x] > 0) {
                            ans.append((char) ('a' + x));
                            count[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}