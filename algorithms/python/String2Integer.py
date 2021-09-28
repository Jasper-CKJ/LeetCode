# @author jasper
# @create 2021-09-28 18:22

class Solution:
    def myAtoi(self, s: str) -> int:
        import re
        return max(min(int(*re.findall('^[+-]?\d+', s.lstrip())), 2 ** 31 - 1), -2 ** 31)
