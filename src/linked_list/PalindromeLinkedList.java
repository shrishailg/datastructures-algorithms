package linked_list;

public class PalindromeLinkedList {

    static boolean isPalindrome = false;

    public static void main(String... args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println(isPalindrome(head));

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(1);

        System.out.println(isPalindrome(head1));

    }


    static{
        System.out.println("Hello Shrishail");
    }

    public static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;

        {
            System.out.println("Hello Shrishail");
        }


        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node headSecond = reverse(slow);

        while (head != null && headSecond != null) {
            if (head.data != headSecond.data) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }

        if (head == null || headSecond == null) {
            isPalindrome = true;
        }

        //this is correct
        reverse(headSecond);

        return isPalindrome;
    }

    //1-->2-->3-->4
    //1-->2-->3-->null
    //4-->3-->null
    private static Node reverse(Node head) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
