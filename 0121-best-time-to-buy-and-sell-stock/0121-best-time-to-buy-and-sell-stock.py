class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        n=len(prices)
        minBuy=float("inf")
        maxProfit=0

        for i in range(n):
            if prices[i]<minBuy:
                minBuy=prices[i]
            else:
                maxProfit=max(maxProfit,prices[i]-minBuy)
        
        return maxProfit

        