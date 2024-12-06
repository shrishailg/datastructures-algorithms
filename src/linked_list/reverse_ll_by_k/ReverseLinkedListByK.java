package linked_list.reverse_ll_by_k;

import linked_list.Node;

public class ReverseLinkedListByK {
    
        public Node reverseKGroup(Node head, int k) {
            if (head == null)
                return head;

            Node current = head; int len = 0;

            while(current != null){
                current = current.next;
                len++;
            }

            if (k> len)
                return head;

            int count=0; Node next, prev = null; current = head;

            while(count < k && current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            if (head != null && current != null) {
                head.next = reverseKGroup(current, k);
            }

            return prev;
        }

    public void printList(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
