# @author jasper
# @create 2021-10-12 11:22
from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums = sorted(nums)
        length = len(nums)
        res = []
        pairs = {}
        for i in range(length - 3):
            for head in range(i + 1, length - 2):
                res_2 = nums[i] + nums[head]
                try:
                    pairs[target - res_2].append([i, head])
                except KeyError:
                    pairs[target - res_2] = [[i, head]]
        for key, temp in pairs.items():
            for pair in temp:
                head = pair[1] + 1
                tail = length - 1
                while head < tail:
                    current = nums[head] + nums[tail]
                    if current == key:
                        result = [nums[pair[0]], nums[pair[1]], nums[head], nums[tail]]
                        if result not in res:
                            res.append(result)
                        head += 1
                    elif current < key:
                        head += 1
                    else:
                        tail -= 1
        return res
