class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode runner = dummy;
        while(n > 0){
            runner = runner.next;
            n--;
        }
        while(runner.next != null){
            runner = runner.next;
            p = p.next;
        }
        // p is at the node we want to delete.  
        p.next = p.next.next;
        return dummy.next;
    }
}