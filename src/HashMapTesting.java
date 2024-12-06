import java.util.*;

public class HashMapTesting {

    public static void main(String... args){
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,0);
        hashMap.put(2,1);
        hashMap.put(3,2);
        hashMap.put(4,3);
        hashMap.put(5,4);

        System.out.println("bofore "+ hashMap);
        hashMap.remove(5);
        System.out.println("after "+ hashMap);

        if (!hashMap.containsKey(6)){
            hashMap.put(6,5);
        }

        System.out.println("final "+ hashMap);

        //get random values with equal probabilities
        Random random = new Random();
        int rand = random.nextInt(hashMap.size());

       for(var entry:hashMap.entrySet()){
           if (entry.getValue() == rand){
               System.out.println("random number is "+ entry.getKey());
           }
       }

    }

}
