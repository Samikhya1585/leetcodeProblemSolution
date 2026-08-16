class Solution(object):
    def stoneGameIX(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """

        count0 = 0
        count1 = 0
        count2 = 0

        for i in range(len(stones)):

            rem = stones[i] % 3

            if rem == 0:
                count0 += 1

            elif rem == 1:
                count1 += 1

            else:
                count2 += 1

        if count0 % 2 == 0:
            return count1 > 0 and count2 > 0

        return abs(count1 - count2) > 2