package two_heaps.top_k_frequent_element;


public class TopFrequentElementTest {

    public static void main(String... args){
        TopFrequentElement topFrequentElement = new TopFrequentElement();

        int[] arr = new int[]{6,0,1,4,9,7,-3,1,-4,-8,4,-7,-3,3,2,-3,9,5,-4,0};

        System.out.println(topFrequentElement.topKFrequent(arr, 6));
         // expected: [-4,0,1,4,9,-3]
    }
}
