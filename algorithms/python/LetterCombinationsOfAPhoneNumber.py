# @author jasper
# @create 2021-10-11 18:26
from typing import List


class Solution:
    digitLetter = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]

    def letterCombinations(self, digits: str) -> List[str]:
        res = [""]
        if not digits:
            return res
        for i in range(len(digits)):
            x = int(digits[i])
            while len(res[0]) != i+1:
                first = res.pop(0)
                for s in self.digitLetter[x]:
                    res.append(first + s)
        return res
