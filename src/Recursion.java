public class Recursion {

    public static void main(String[] args){
        A(3);
    }

    public static  void A(int n){
        if (n>=1){
            A(n-1);
            System.out.println(n);
            A(n-1);
        }
    }
}
