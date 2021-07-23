class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        whlie(fast.next != null && fast !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}