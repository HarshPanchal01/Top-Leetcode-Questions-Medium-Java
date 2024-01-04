class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Swap_Nodes_In_Pairs {
    public static void print(ListNode node) {
        ListNode currentNode = node;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { // if list is empty or only contains one node
            return head;
        }
        // create dummy to simplify the swapping
        ListNode dummy = new ListNode(0);
        // set dummy.next to the head of the list
        dummy.next = head;
        // create a current pointer and make it point at the dummy node
        ListNode current = dummy;
        // this while loop executes as long as there are atleast two nodes to swap
        while (current.next != null && current.next.next != null) {
            // create first node which represents the current node and second which represents the next node in the list
            ListNode first = current.next;
            ListNode second = current.next.next;
            // performing the swapping
            first.next = second.next; // sets the next of 1 to the next of 2 ie. 1 -> 3
            second.next = first; // makes 2 point to 1 ie. 2 -> 1
            current.next = second; // makes dummy point to 2 ie. 0 -> 2
            // essentially after first iteration list becomes [0,2,1,3,4]
            // after swapping is done current is moved two steps forward to the next pair of nodes
            current = current.next.next;
        }
        // returns the modified list
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        print(swapPairs(head));
    }
}
