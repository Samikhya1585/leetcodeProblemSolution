import java.util.*;

class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] cnt = new long[max + 1];

        // cnt[g] = how many numbers are divisible by g
        for (int g = 1; g <= max; g++) {
            for (int j = g; j <= max; j += g) {
                cnt[g] += freq[j];
            }
        }

        long[] exact = new long[max + 1];

        // exact[g] = number of pairs whose gcd is exactly g
        for (int g = max; g >= 1; g--) {

            long c = cnt[g];
            exact[g] = c * (c - 1) / 2;

            for (int j = g + g; j <= max; j += g) {
                exact[g] -= exact[j];
            }
        }

        // prefix[i] = number of pairs with gcd <= i
        long[] prefix = new long[max + 1];

        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long k = queries[i] + 1; // 0-indexed -> 1-indexed

            int l = 1;
            int r = max;

            while (l < r) {

                int mid = l + (r - l) / 2;

                if (prefix[mid] >= k)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}