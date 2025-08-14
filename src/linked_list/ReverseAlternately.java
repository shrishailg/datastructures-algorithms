package linked_list;

public class ReverseAlternately {

    public Node reverseAlternate(Node head) {
        if(head == null || head.next == null){
            return head;
        }

        Node secondHalfHead = reverse(head);
        Node firstHalfHead = head;

        while(firstHalfHead != null && secondHalfHead != null) {
            Node temp = firstHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            firstHalfHead = temp;

            temp = secondHalfHead.next;
            secondHalfHead.next = firstHalfHead;
            secondHalfHead = temp;
        }

        if (firstHalfHead != null) {
            firstHalfHead = firstHalfHead.next;
        }

        return head;
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while(current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
