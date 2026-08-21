class Solution(object):

    def findKthSmallest(self, coins, k):
        """
        :type coins: List[int]
        :type k: int
        :rtype: int
        """

        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a

        def lcm(a, b):
            return a // gcd(a, b) * b

        # Count valid amounts <= x
        def count(x):

            n = len(coins)
            total = 0

            # Try every non-empty subset
            for mask in range(1, 1 << n):

                multiple = 1
                bits = 0
                valid = True

                for i in range(n):

                    if mask & (1 << i):

                        bits += 1

                        multiple = lcm(multiple, coins[i])

                        if multiple > x:
                            valid = False
                            break

                if not valid:
                    continue

                ways = x // multiple

                # Odd number of coins -> add
                if bits % 2 == 1:
                    total += ways

                # Even number of coins -> subtract
                else:
                    total -= ways

            return total

        # Binary search
        left = 1
        right = min(coins) * k

        while left < right:

            mid = left + (right - left) // 2

            if count(mid) >= k:
                right = mid
            else:
                left = mid + 1

        return left
        