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

// Time: O(n)
// Space O(n)

class Solution{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //Recurive Solution
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}

// Time: O(n)
// Space O(n)

