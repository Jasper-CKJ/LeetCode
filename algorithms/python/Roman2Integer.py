# @author jasper
# @create 2021-09-30 17:39

class Solution:
    def romanToInt(self, s: str) -> int:
        roman_dim = {'M': 1000, 'D': 500, 'C': 100, 'L': 50, 'X': 10, 'V': 5, 'I': 1}
        res = 0
        for i in range(len(s) - 1):
            if roman_dim[s[i]] < roman_dim[s[i + 1]]:
                res -= roman_dim[s[i]]
            else:
                res += roman_dim[s[i]]
        return res + roman_dim[s[-1]]
