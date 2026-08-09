class Solution {
    public int stoneGameII(int[] piles) {

        int n = piles.length;

        // suffix[i] = sum of piles from i to end
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {

            for (int M = n; M >= 1; M--) {

                // Can take all remaining piles
                if (i + 2 * M >= n) {
                    dp[i][M] = suffix[i];
                    continue;
                }

                int best = 0;

                for (int X = 1; X <= 2 * M; X++) {

                    int newM = Math.max(M, X);

                    int current =
                        suffix[i] - dp[i + X][newM];

                    best = Math.max(best, current);
                }

                dp[i][M] = best;
            }
        }

        return dp[0][1];
    }
}