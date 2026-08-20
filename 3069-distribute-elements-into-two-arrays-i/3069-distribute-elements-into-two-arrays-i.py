class Solution(object):
    def resultArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        arr1=[]
        arr2=[]
        n=len(nums)

        arr1.append(nums[0])
        arr2.append(nums[1])

        for i in range(2,n):
            list1=arr1[-1]
            list2=arr2[-1]

            if list1>list2:
                arr1.append(nums[i])
            else:
                arr2.append(nums[i])

        return arr1+arr2


        