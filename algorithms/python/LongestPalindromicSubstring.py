# @author jasper
# @create 2021-09-26 15:55
import math


class Solution:

    def longestPalindrome1(self, s: str) -> str:
        length = len(s)
        p = [[False] * length for _ in range(length)]
        maxLen = 0
        result = ""
        for l in range(1, length + 1):
            for start in range(length):
                end = start + l - 1
                if end >= length:
                    break

                p[start][end] = (l in (1, 2) or p[start + 1][end - 1]) and s[start] == s[end]
                if p[start][end] and l > maxLen:
                    maxLen = l
                    print(start, end, l)
                    result = s[start: end + 1]
        return result

    def expandAroundCenter(self, s: str, left: int, right: int) -> int:
        l, r = left, right
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return r - l - 1

    def longestPalindrome2(self, s: str) -> str:
        start = end = 0
        for i in range(len(s)):
            len1 = self.expandAroundCenter(s, i, i)
            len2 = self.expandAroundCenter(s, i, i + 1)
            _len = max(len1, len2)
            if _len > end - start + 1:
                start = i - math.floor((_len - 1) / 2)
                end = i + math.floor(_len / 2)
        return s[start:end + 1]

    def proProcess(self, s: str) -> str:
        length = len(s)
        if length == 0:
            return "^$"
        ret = "^"
        for i in s:
            ret += "#" + i
        return ret + "#$"

    def longestPalindrome3(self, s: str) -> str:
        newS = self.proProcess(s)
        p = [0] * len(newS)
        c = r = 0
        for i in range(1, len(newS) - 1):
            iMirror = 2 * c - i
            p[i] = min(r - i, p[iMirror]) if r > i else 0

            while newS[i + 1 + p[i]] == newS[i - 1 - p[i]]:
                p[i] += 1

            if i + p[i] > r:
                c = i
                r = i + p[i]

        maxLen, index = max(p), p.index(max(p))
        start = math.floor((index - maxLen) / 2)
        return s[start: start + maxLen]
