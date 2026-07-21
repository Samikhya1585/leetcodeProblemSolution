class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";
        int n = t.length();

        int ans = ones;

        for (int i = 1; i < n - 1;) {

            if (t.charAt(i) != '1') {
                i++;
                continue;
            }

            int j = i;
            while (j < n && t.charAt(j) == '1') j++;

            // one block
            if (i > 0 && j < n &&
                t.charAt(i - 1) == '0' &&
                t.charAt(j) == '0') {

                int left = i - 1;
                while (left >= 0 && t.charAt(left) == '0') left--;

                int right = j;
                while (right < n && t.charAt(right) == '0') right++;

                int zeroLen = right - left - 1;
                int oneLen = j - i;

                ans = Math.max(ans, ones - oneLen + zeroLen);
            }

            i = j;
        }

        return ans;
    }
}