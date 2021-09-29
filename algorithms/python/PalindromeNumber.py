# @author jasper
# @create 2021-09-29 14:09

class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        while x != 0:
            x, pop = divmod(x, 10)
            res = res * 10 + pop
        return res

    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        res = self.reverse(x)
        return res == x
