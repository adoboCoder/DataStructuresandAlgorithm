public class LCE_160IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        
        while(lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        
        while(lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }
        
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}