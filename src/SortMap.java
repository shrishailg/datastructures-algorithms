import java.util.*;

public class SortMap {

    public static void main(String... rags){

        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

//        List<List<Integer>> setsList = new ArrayList<>();
//
//        setsList.add(new ArrayList<>());


    }
}
