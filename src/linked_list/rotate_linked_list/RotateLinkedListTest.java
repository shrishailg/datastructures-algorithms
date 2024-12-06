package linked_list.rotate_linked_list;

import linked_list.Node;

public class RotateLinkedListTest {

    public static void main(String... args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        RotateLinkedList rotateLinkedList = new RotateLinkedList();

        head = rotateLinkedList.rotateLL(head, 3);
        rotateLinkedList.printList(head);
    }
}
