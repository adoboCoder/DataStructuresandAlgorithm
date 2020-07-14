// Facebook #1 asked question according to Leetcode as of 6/25/2020
class Solution{
    public ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node: lists)
            if (node != null)
                queue.add(node);
        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
        
            if(tail.next != null)
            queue.add(tail.next);
            
        }
        return dummy.next;
    }
}