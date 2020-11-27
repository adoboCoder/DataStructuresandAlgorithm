/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode secondHalf = reverse(slow.next);
        ListNode firstHalf = head;
        
        while(secondHalf != null && firstHalf != null){
            if(firstHalf.val != secondHalf.val){
                return false;
            }
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    
}
/*

Time: O(n)
Space: O(1)

This problem can be solved with the two pointer technique.  One pointer is slow which will move by one (slow.next) and another pointer called
fast (fast.next.next).  The fast pointer will move twice the speed of the slow pointer, but initially, both of them will start at the head of the 
linked list.

*/