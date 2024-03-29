class LinkedLists{
    Node head;
    class Node{
        int data;
        Node next;

        //Constructor

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static LinkedLists insert(LinkedLists list, int data){
        Node newNode = new Node(data);
        newNode.next = null;

        //If list is empty, make newNode the head.
        if(list.head == null){
            list.head = newNode;
        }
        else{
            //Traverse until the end of the list, and insert newNode there
            Node last = list.head;
            while(last.next != null){
                last = last.next;
            }
            // last.next is the last node in list, setting the next pointer to newNode.
            last.next = newNode;
        }
        return list;
    }

    public static LinkedLists deleteByKey(LinkedLists list, int key){
        Node currentNode = list.head;
        Node prev = null;

        //If head node is the single node in the list and it contains the key to be deleted.
        if(currentNode != null && currentNode == key){
            list.head = currentNode.next;
        }
        return list;

    }

    public static void printList(LinkedLists list) {
        Node currentNode = list.head;
        System.out.println("LinkedList :");
        while(currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }
    public static void main(String[] args) {
        LinkedLists list = new LinkedLists(1);
        list.next = new LinkedLists(2);
        printList(list);
    }
}