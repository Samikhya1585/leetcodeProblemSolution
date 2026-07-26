class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        n=len(nums)
        nums.sort()

        prod1=nums[n-1]*nums[n-2]*nums[n-3]
        prod2=nums[0]*nums[1]*nums[n-1]

        maxprod=max(prod1,prod2)

        return maxprod
        