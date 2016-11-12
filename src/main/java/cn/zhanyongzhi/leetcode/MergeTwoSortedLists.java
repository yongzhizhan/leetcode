package cn.zhanyongzhi.leetcode;

public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1)
            return l2;

        if(null == l2)
            return l1;

        ListNode newList;
        if(l1.val > l2.val){
            newList = l2;
            l2 = l2.next;
        }else{
            newList = l1;
            l1 = l1.next;
        }

        ListNode walk = newList;

        while(true){
            if(null != l1 && null != l2){
                if(l1.val > l2.val){
                    walk.next = l2;
                    l2 = l2.next;
                }else{
                    walk.next = l1;
                    l1 = l1.next;
                }

                walk = walk.next;
            }

            if(null == l1){
                walk.next = l2;
                break;
            }

            if(null == l2){
                walk.next = l1;
                break;
            }
        }

        return newList;
    }
}
