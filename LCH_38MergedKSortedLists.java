// Facebook #1 asked question according to Leetcode as of 6/25/2020
class Solution{
    public ListNode mergeKList(ListNode[] lists){
        if (lists == null || lists.length() == 0){
            return null;
        }
// using Java 8 allows me to use lambda functions ((a,b) -> (a.val - b.val)) inline sorting!
        PriorityQue <ListNode> queue = new PriorityQue<ListNode> (lists.length, (a,b) -> (a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node: lists){
            if (node != null){
                que.add(node);
            }
        while (!que.isEmpty()){
            tail.next = que.poll();
            tail = tail.next;
        }
            if(tail.next != null){
                que.add(tail.netx);
            }
        }
        return dummy.next;
    }
}