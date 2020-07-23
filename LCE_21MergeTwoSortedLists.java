class Solution{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //Iterative Solution
        ListNode answer = new ListNode();
        ListNode current = answer;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null ? l2 : l1;
        return answer.next;
    }
}