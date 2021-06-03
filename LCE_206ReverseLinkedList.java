class Solution{
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
}

class Solution{
    public ListNode reverseList(ListNode head){
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode newHead){
        if(head == null){
            return newHead;
        }

        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;

        return reverse(head, newHead); //Recursive solution
    }
}