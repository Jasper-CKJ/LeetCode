# @author jasper
# @create 2021-09-26 18:15

class Solution:
    def reverse(self, x: int) -> int:
        flag = False
        if x < 0:
            flag = True
            x = -x
        l = [i for i in str(x)]
        l.reverse()
        n = int("".join(l))
        n = -n if flag else n
        n = 0 if n < -2 ** 31 or n > 2 ** 31 - 1 else n
        return n
