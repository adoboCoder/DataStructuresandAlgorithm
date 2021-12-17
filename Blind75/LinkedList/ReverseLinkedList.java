package Blind75.LinkedList;

public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        ListNode dummy = reverse(head1);

        while(dummy != null) {
            System.out.print(dummy.val);
            dummy = dummy.next;
        }
    }
}
