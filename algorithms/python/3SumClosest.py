# @author jasper
# @create 2021-10-11 18:05
import sys
from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        sub = sys.maxsize
        res = 0
        nums = sorted(nums)
        for i in range(len(nums) - 2):
            if i == 0 or nums[i] != nums[i - 1]:
                head, tail = i + 1, len(nums) - 1
                while head < tail:
                    if abs(nums[head] + nums[tail] + nums[i] - target) < sub:
                        res = nums[head] + nums[tail] + nums[i]
                        sub = abs(res - target)
                    if nums[head] + nums[tail] + nums[i] < target:
                        head += 1
                    else:
                        tail -= 1
        return res
