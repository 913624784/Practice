/**
 * public class ListNode {
 * int val;
 * ListNode next = null;
 * <p>
 * ListNode(int val) {
 * this.val = val;
 * }
 * }
 */


import java.util.ArrayList;
import java.util.Stack;

public class J_3PrintLinkedList {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> n = new Stack<Integer>();
        while (listNode != null) {
            n.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> m = new ArrayList<Integer>();
        while (!n.isEmpty()) {
            m.add(n.pop());
        }
        return m;
    }


    public static void main(String[] args) {
        System.out.println(printListFromTailToHead(new ListNode(9)));
    }
}
