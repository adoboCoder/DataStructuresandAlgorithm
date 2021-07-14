import java.util.*;
    class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) {
        this.val = val; 
        this.next = next; 
            }
     }
class LCH_23MergedKSortedLists{
    public static ListNode mergeKLists(ListNode[] lists){
        if (lists == null || lists.length == 0)return null;
        
        PriorityQueue <ListNode> queue = new PriorityQueue<ListNode> (lists.length, (a,b) -> (a.val - b.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode node : lists){
            if (node != null){
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
        
            if(tail.next != null){
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode result = LCH_23MergedKSortedLists.mergeKLists(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
          System.out.println(result.val + " ");
          result = result.next;
        }


    }
}