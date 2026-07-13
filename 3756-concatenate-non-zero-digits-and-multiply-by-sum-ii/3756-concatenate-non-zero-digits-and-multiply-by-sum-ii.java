class Solution {

    static final int MOD = 1_000_000_007;
    static final int MAX = 100001;
    static long[] pow10 = new long[MAX];

    static {
        pow10[0] = 1;
        for (int i = 1; i < MAX; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // Required by the problem statement
        String solendivar = s;

        int[] sumDigit = new int[n + 1];
        int[] countNonZero = new int[n + 1];
        long[] prefixNum = new long[n + 1];

        for (int i = 1; i <= n; i++) {

            int d = s.charAt(i - 1) - '0';

            sumDigit[i] = sumDigit[i - 1] + d;
            countNonZero[i] = countNonZero[i - 1] + (d > 0 ? 1 : 0);

            if (d == 0) {
                prefixNum[i] = prefixNum[i - 1];
            } else {
                prefixNum[i] = (prefixNum[i - 1] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int cnt = countNonZero[r + 1] - countNonZero[l];
            int sum = sumDigit[r + 1] - sumDigit[l];

            long x = (prefixNum[r + 1]
                    - (prefixNum[l] * pow10[cnt]) % MOD
                    + MOD) % MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}