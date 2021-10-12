# @author jasper
# @create 2021-10-12 11:52

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        index = []
        pos = head
        while pos is not None:
            index.append(pos)
            pos = pos.next
        ls = len(index)
        if n == ls:
            if ls > 1:
                return index[1]
            else:
                return None
        else:
            index_pos = ls - n - 1
            index[index_pos].next = index[index_pos + 1].next
            return head
