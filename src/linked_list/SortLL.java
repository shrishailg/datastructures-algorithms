package linked_list;

public class SortLL {

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 5 -> 1 -> 32 -> 10 -> 78
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        head = sort(head);
        printList(head);
    }


    public static Node sort(Node head) {
        Node current = head;

        while (current != null && current.next != null) {
            Node current1 = current;
            boolean swapped = false;

            while (current1 != null && current1.next != null) {
                Node next = current1.next;

                if (current1.data > next.data) {
                    swapped = true;
                    int data = current1.data;
                    current1.data = next.data;
                    next.data = data;
                }

                current1 = current1.next;
            }

            if (!swapped) {
                return head;
            }
        }



        return head;
    }

    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
