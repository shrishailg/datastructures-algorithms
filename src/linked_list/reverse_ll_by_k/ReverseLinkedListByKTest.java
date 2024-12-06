package linked_list.reverse_ll_by_k;

import linked_list.Node;

public class ReverseLinkedListByKTest {

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        ReverseLinkedListByK reverseLinkedListByK = new ReverseLinkedListByK();

        head = reverseLinkedListByK.reverseKGroup(head, 2);
        reverseLinkedListByK.printList(head);
    }
}
