# @author jasper
# @create 2021-09-24 17:03
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        result = i = 0
        d = {}
        for j in range(len(s)):
            if s[j] in d.keys():
                i = max(d[s[j]] + 1, i)
            result = max(result, j - i + 1)
            d[s[j]] = j
        return result
