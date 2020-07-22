class Solution{
    public ListNode mergeKLists(ListNode[] lists){
<<<<<<< HEAD
        if (lists == null || lists.length == 0)return null;
        
        PriorityQueue <ListNode> queue = new PriorityQueue<ListNode> (lists.length, (a,b) -> (a.val - b.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node : lists)
=======
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a,b)-> a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node: lists)
>>>>>>> cae38e55d6a5dc58da86e48198d8f0bd828be043
            if (node != null)
                queue.add(node);
        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
        
            if(tail.next != null)
<<<<<<< HEAD
                queue.add(tail.next);
=======
            queue.add(tail.next);
>>>>>>> cae38e55d6a5dc58da86e48198d8f0bd828be043
            
        }
        return dummy.next;
    }
}