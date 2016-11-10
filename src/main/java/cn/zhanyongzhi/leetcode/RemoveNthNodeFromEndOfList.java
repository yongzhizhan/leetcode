package cn.zhanyongzhi.leetcode;

public class RemoveNthNodeFromEndOfList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(null == head)
            return null;

        if(0 == n)
            return head;

        int len = 0;
        ListNode walk = head;

        while(null != walk){
            walk = walk.next;
            len++;
        }

        int tagetCount = len - n;
        if(1 > tagetCount)
            return head.next;

        //walk to target
        walk = null;
        while(0 != tagetCount){
            tagetCount--;

            if(null == walk)
                walk = head;
            else
                walk = walk.next;
        }

        if(walk == null)
            head = head.next;
        else
            walk.next = walk.next.next;

        return head;
    }
}
