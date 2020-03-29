package XXX;

public class ReverserLink {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode preHead = head;
        ListNode CurNode = null;
        for (int i = 0; head != null; i++) {
            preHead = head.next;
            head.next = CurNode;
            CurNode = head;
            head = preHead;
        }
        return CurNode;
    }

    /**
     * 非递归
     * @param head
     * @return
     */
//    public  ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        while(head!=null){
//            ListNode tmp = head.next;
//            head.next = prev;
//            prev = head;
//            head = tmp;
//        }
//        return prev;
    /**
     * 递归
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head) {
//        if(head==null||head.next ==null)
//            return head;
//        ListNode prev = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return prev;
//    }
}




