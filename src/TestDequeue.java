import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;

public class TestDequeue {

    public static void main(String[] args){
        Deque<Integer> integerDeque = new LinkedList<>();

        integerDeque.addFirst(1);
        integerDeque.addFirst(2);
        integerDeque.addFirst(3);
        integerDeque.addFirst(4);

        System.out.println(integerDeque);

        integerDeque.removeLast();
        integerDeque.remove(3);


        integerDeque.peek();

        System.out.println(integerDeque);
    }
}
