import java.util.*;

import org.w3c.dom.Node;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Remove_Nth_Node_From_End_of_List {
    public static void print(ListNode node) {
        ListNode currentNode = node;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // create a dummy head
        dummy.next = head; // set the head to come after the dummy we created
        // create slow and fast pointers
        ListNode slow = dummy;
        ListNode fast = dummy;
        // the fast pointer is moved n+1 steps forward to create a gap of n nodes between the slow and fast pointers. It iterates n+1 times moving fast pointer to the n+1 node
        for (int i = 1; i <= n+1; i++) {
            fast = fast.next;
        }
        // both slow and fast pointers are now moved one node at a time until the fast pointer reaches the end of the list null. At this point the slow pointer is at node nth from the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // the node following the slow pointer is set to its next-next node effectively removing the nth node
        slow.next = slow.next.next;
        // return the modified list without the dummy head
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;

        print(removeNthFromEnd(head, n));
    }
}
