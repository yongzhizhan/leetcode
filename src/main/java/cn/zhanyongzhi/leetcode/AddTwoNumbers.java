package cn.zhanyongzhi.leetcode;

public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = l1;
        ListNode currentNode = l1;
        ListNode prevNode = null;
        int carry = 0;
        int sum = 0;
        int val1 = 0;
        int val2 = 0;

        while(null != l1 || null != l2){
            prevNode = currentNode;

            val1 = 0;
            val2 = 0;

            if(null != l1) {
                val1 = l1.val;
                l1 = l1.next;
            }

            if(null != l2) {
                val2 = l2.val;
                l2 = l2.next;
            }

            sum = val1 + val2 + carry;
            if(9 < sum){
                carry = 1;
                sum = sum - 10;
            }else{
                carry = 0;
            }

            currentNode.val = sum;

            if(null != l1)
                currentNode = l1;
            else
                currentNode = l2;

            prevNode.next = currentNode;
        }

        if(0 != carry){
            prevNode.next = new ListNode(carry);
        }

        return header;
    }
}
