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
        current.next = l1 == null ?
         l2 : l1;
        return answer.next;
    }
}
/*
The iterative solution requires a dummy node(answer), then later there is a current pointer that points to answer.
answer will always have 0 at the head because of current = answer (line5).  When returning the answer I will return answer.next to 
get rid of the 0 at the head.

Example:
l1: [1,2,4]
l2: [1,3,4]

First iteration of the while loop: 

l1.val = 1 and l2.val = 2 
current: [0,1,3,4] -> current: [1,3,4]
l2:[3,4]





*/
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

// Time: O(m+n)
// Space O(m+n)

/* The recursive solution is a little bit cleaner in my opinion.  
It doesn't require any additional ListNode, so there's no keeping track of the pointer.


*/
