package stack.remove_k_duplicates;

public class RemoveDuplicatesTest {

    public static void main(String... args ){
        String str = "deeedbbcccbdaa";

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();

        System.out.println(removeDuplicates.remove(str, 3));
    }
}
