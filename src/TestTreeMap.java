import java.util.*;

public class TestTreeMap {

    public static void main(String[] args) {

        TreeSet<int[]> treeSet = new TreeSet<>((a,b) -> a[0]-b[0]);

        treeSet.add(new int[]{2,12});
        treeSet.add(new int[]{1,11});
        treeSet.add(new int[]{0,10});
        treeSet.add(new int[]{3,13});

//        System.out.println(treeSet.first()[1]);

        int[] value = treeSet.pollFirst();
//        assert value != null;
//        System.out.println(value[1]);

//        for (var val : treeSet) {
//            System.out.println(val[1]);
//        }

//        treeSet.remove(new int[]{0,10});

        for (var val : treeSet) {
            System.out.println(val[1]);
        }

//        String tep = "abc";
//        System.out.println(tep.substring(1));
//
//        String x = test1();
//        System.out.println(x);
//
//        //power of number
//        System.out.println((int)Math.pow(2, 3));
//
//        //log2
//        System.out.println((int)(Math.log(1024)/Math.log(2)));
    }

    public static String test1(){
        String str = "";
        return str = "Shrishail";
    }
}
