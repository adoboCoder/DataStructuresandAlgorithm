class LCM_143ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        
        //Step1 - find the middle node
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // step2 - reverse the second half
        ListNode preMiddle = slow;
        ListNode preCurrent = slow.next;

        while(preCurrent.next != null) {
            ListNode temp = preCurrent.next;
            preCurrent.next = temp.next;
            temp.next = preMiddle.next;
            preMiddle.next = temp;
        }

        // step3 - merge the two lists
        ListNode p1 = head;
        ListNode p2 = preMiddle.next;

        while(p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }
}