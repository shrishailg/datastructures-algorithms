package linked_list.rotate_linked_list;

import linked_list.Node;

public class RotateLinkedList {

    public Node rotateLL(Node head, int k){
        int count=0; Node mid = head, last = head;

        while(last != null && last.next != null){
            last = last.next;
        }


        while(count < k-1 && mid != null){
            mid = mid.next;
            count++;
        }

        Node temp = mid.next;
        mid.next = null;
        last.next = head;
        head = temp;


        return head;
    }

    public void printList(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
