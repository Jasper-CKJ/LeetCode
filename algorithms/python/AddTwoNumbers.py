# @author jasper
# @create 2021-09-24 11:50

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy_head = ListNode(0)
        p, q, curr = l1, l2, dummy_head
        carry = 0
        while p or q:
            x = p.val if p else 0
            y = q.val if q else 0
            add_sum = x + y + carry
            carry = int(add_sum / 10)
            curr.next = ListNode(int(add_sum % 10))
            curr = curr.next
            p = p.next if p else None
            q = q.next if q else None

        if carry > 0:
            curr.next = ListNode(carry)

        return dummy_head.next
