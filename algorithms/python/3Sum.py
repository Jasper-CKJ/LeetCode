# @author jasper
# @create 2021-10-11 16:58
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums = sorted(nums)
        for i in range(len(nums) - 2):
            if i == 0 or nums[i] != nums[i - 1]:
                head, tail, sum = i + 1, len(nums) - 1, -nums[i]
                while head < tail:
                    if nums[head] + nums[tail] == sum:
                        res.append([nums[i], nums[head], nums[tail]])
                        while head < tail and nums[head] == nums[head + 1]:
                            head += 1
                        while head < tail and nums[tail] == nums[tail - 1]:
                            tail -= 1
                        head += 1
                        tail -= 1
                    elif nums[head] + nums[tail] < sum:
                        head += 1
                    else:
                        tail -= 1
        return res
