package leetcode;

public class 判断链表是否有环 {
    public class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
}
