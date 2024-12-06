package linked_list.reverse_ll_by_k;

import linked_list.Node;

public class ReverseLinkedListByKAlternate {

    public Node reverse(Node head, int k){
        int count=0; Node next, prev = null, current = head;

        while(count < k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (head != null){
            head.next = current;
        }

        count = 0;
        while(count < k-1 && current != null){
            current = current.next;
            count++;
        }

        if (current != null){
            current.next = reverse(current.next, k);
        }

        return prev;
    }
}
