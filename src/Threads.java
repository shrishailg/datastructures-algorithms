public class Threads {

    public static void main(String[] args) {

        Thread t = new Thread(() -> System.out.println("child thread"));

        t.start();

    }
}
