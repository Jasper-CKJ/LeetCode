# @author jasper
# @create 2021-09-30 17:06
from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        _max = 0
        left = 0
        right = len(height) - 1
        while left < right:
            _max = max(_max, min(height[left], height[right]) * (right - left))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return _max
