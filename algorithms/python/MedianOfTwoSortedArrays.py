# @author jasper
# @create 2021-09-26 11:29
import math
from typing import List


class Solution:

    def getKth(self, nums1: List[int], start1: int, end1: int, nums2: List[int], start2: int, end2: int, k: int):
        len1, len2 = end1 - start1 + 1, end2 - start2 + 1
        if len1 > len2:
            return self.getKth(nums2, start2, end2, nums1, start1, end1, k)
        if len1 == 0:
            return nums2[start2 + k - 1]
        if k == 1:
            return min(nums1[start1], nums2[start2])

        mid_k = math.floor(k / 2)

        i, j = start1 + min(len1, mid_k) - 1, start2 + min(len2, mid_k) - 1
        if nums1[i] > nums2[j]:
            return self.getKth(nums1, start1, end1, nums2, j + 1, end2, k - min(len2, mid_k))
        else:
            return self.getKth(nums1, i + 1, end1, nums2, start2, end2, k - min(len1, mid_k))

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        len1, len2 = len(nums1), len(nums2)
        left = math.floor((len1 + len2 + 1) / 2)
        right = math.floor((len1 + len2 + 2) / 2)
        return (self.getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) +
                self.getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5
