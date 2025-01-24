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

        String[] strings = {"ab", "cdsa", "a", "nd"};

        Arrays.sort(strings, (a,b) -> a.length() - b.length());

        System.out.println(Arrays.toString(strings));


        //sort map by values
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("Math", 98);
        map1.put("Data Structure", 85);
        map1.put("Database", 91);
        map1.put("Java", 95);
        map1.put("Operating System", 79);
        map1.put("Networking", 80);

        // Convert map entries to list

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map1.entrySet());

        // Sort the list based on values
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // Rebuild the map from the sorted list
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Print the sorted map
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
