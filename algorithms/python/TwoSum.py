# @author jasper
# @create 2021-09-23 18:39
from typing import List


class Solution:

    # 暴力解法
    # 时间复杂度：O(n²)
    # 空间复杂度：O(1)
    def twoSum1(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

    # 使用has会map，空间换时间
    # 时间复杂度：O(n)
    # 空间复杂度：O(n)
    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        d = {}
        for i in range(len(nums)):
            if target - nums[i] in d.keys():
                return [d[target - nums[i]], i]
            else:
                d[target - nums[i]] = i
