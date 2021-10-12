/**
@author jasper
@create 2021-10-12 11:52
 */

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode p = head;
        while (p!= null){
            p = p.next;
            len ++;
        }

        if (len == 1) {
            return null;
        }

        int rmNodeIndex = len - n;
        //如果删除的是头结点
        if (rmNodeIndex == 0) {
            return head.next;
        }

        //找到被删除结点的前一个结点
        p = head;
        for (int i = 0; i < rmNodeIndex - 1; i++) {
            p = p.next;
        }

        //改变指向
        p.next = p.next.next;
        return head;
    }
}
