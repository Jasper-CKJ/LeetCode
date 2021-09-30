# @author jasper
# @create 2021-09-30 17:20
import math


class Solution:
    def intToRoman(self, num: int) -> str:
        roman_dim = [[1000, 'M'], [900, 'CM'], [500, 'D'], [400, 'CD'],
                     [100, 'C'], [90, 'XC'], [50, 'L'], [40, 'XL'], [10, 'X'],
                     [9, 'IX'], [5, 'V'], [4, 'IV'], [1, 'I']]
        if num == 0:
            return ''
        res = ''
        i = 0
        while num > 0:
            k = math.floor(num / roman_dim[i][0])
            for j in range(k):
                res += roman_dim[i][1]
                num -= roman_dim[i][0]
            i += 1
        return res
