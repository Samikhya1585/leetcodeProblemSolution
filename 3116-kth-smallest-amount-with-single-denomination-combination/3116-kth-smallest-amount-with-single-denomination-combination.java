class Solution {

    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    // Count how many different amounts <= x
    // can be made using at least one coin.
    public long count(long x, int[] coins) {

        int n = coins.length;
        long total = 0;

        // Try every non-empty subset of coins
        for (int mask = 1; mask < (1 << n); mask++) {

            long multiple = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    multiple = lcm(multiple, coins[i]);

                    // No multiple of this LCM can be <= x
                    if (multiple > x) {
                        break;
                    }
                }
            }

            if (multiple > x) {
                continue;
            }

            long ways = x / multiple;

            // Odd subset -> add
            if (bits % 2 == 1) {
                total += ways;
            }
            // Even subset -> subtract
            else {
                total -= ways;
            }
        }

        return total;
    }

    public long findKthSmallest(int[] coins, int k) {

        long left = 1;

        // Maximum possible answer:
        // smallest coin * k
        long right = (long) coins[0] * k;

        for (int coin : coins) {
            right = Math.min(right, (long) coin * k);
        }

        // Binary search
        while (left < right) {

            long mid = left + (right - left) / 2;

            if (count(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}