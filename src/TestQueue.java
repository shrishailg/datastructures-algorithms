import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue);
        queue.remove(2);

        queue.addAll(new ArrayList<>());
        System.out.println(queue);

    }
}
