# @author jasper
# @create 2021-10-12 13:50
from typing import List


class Solution:
    """

    dp[1] = "()"
    dp[0] = ""
    """

    def generateParenthesis(self, n: int) -> List[str]:
        dp = [[] for _ in range(n + 1)]
        dp[0] = [""]
        for i in range(1, n + 1):
            for p in range(i):
                for left in dp[i - p - 1]:
                    for right in dp[p]:
                        dp[i].append("(" + left + ")" + right)
        return dp[n]
