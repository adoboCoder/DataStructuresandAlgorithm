public class Solution{
    public boolean hasCycle(ListNode head){
        ListNode slow = null;
        ListNode fast = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow = fast){
                return true;
            }
        }
        return false;
    }
}