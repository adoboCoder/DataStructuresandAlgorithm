class Solution{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast.next != null){
            fast = fast.next;
            if(n-- <= 0){
                slow = slow.next;
            }
        }
        slow.next = slow.next.next
        return dummy.next
    }
}