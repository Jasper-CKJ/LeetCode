# @author jasper
# @create 2021-09-26 17:33

class Solution:
    def convert1(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        curRow = 0
        goingDown = False
        p = [""] * min(numRows, len(s))
        for c in s:
            p[curRow] += c
            if curRow == 0 or curRow == numRows - 1:
                goingDown = not goingDown
            curRow += 1 if goingDown else -1
        return "".join(p)

    def convert2(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        result = ""
        cycleLen = 2 * numRows - 2
        for i in range(numRows):
            for j in range(len(s) - i, cycleLen):
                result += s[j + i]
                if i != 0 and i != numRows - 1 and j + cycleLen - i < len(s):
                    result += s[j + cycleLen - i]
        return result
