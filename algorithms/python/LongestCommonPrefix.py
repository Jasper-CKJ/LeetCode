# @author jasper
# @create 2021-09-30 17:53
from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        res = min(strs)
        for i in range(1, len(res)+1):
            s = res[:i]
            for j in strs:
                if not j.startswith(s):
                    return s[:-1]
        return res
