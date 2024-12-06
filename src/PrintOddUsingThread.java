public class PrintOddUsingThread {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            print(1);
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            print(0);
        });

        t2.start();
    }

    static void print(int start) {
        for(int i=start;i<10;i+=2) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
