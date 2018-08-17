package leetcode;

public class 有序链表删除重复节点 {
    public class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
