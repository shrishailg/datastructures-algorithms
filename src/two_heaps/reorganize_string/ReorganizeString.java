package two_heaps.reorganize_string;

import java.util.PriorityQueue;

public class ReorganizeString {

    public  String reorganizeString(String string) {

        int[] list = new int[26];
        for (var ch : string.toCharArray()){
            list[ch-'a'] = list[ch-'a'] + 1;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)-> list[b-'a']-list[a-'a']);

        for (var cha1 : string.toCharArray())
            if (!maxHeap.contains(cha1))
                maxHeap.add(cha1);



        StringBuilder str = new StringBuilder();
        while(maxHeap.size() >= 2){
            Character char1 = maxHeap.poll();
            Character char2 = maxHeap.poll();

            str.append(char1);
            str.append(char2);

            list[char1 -'a'] =  list[char1 - 'a'] - 1;
            list[char2 -'a'] = list[char2 - 'a'] - 1;

            if (list[char1 -'a'] > 0){
                maxHeap.add(char1);
            }

            if (list[char2 -'a'] > 0){
                maxHeap.add(char2);
            }
        }

        while(!maxHeap.isEmpty()){
            Character char1 = maxHeap.poll();
            str.append(char1);

            list[char1 -'a'] = list[char1 -'a'] - 1;
            if (list[char1 -'a'] > 0){
                maxHeap.add(char1);
            }
        }

        for(int i=1;i<str.length();i++){
            if (str.charAt(i-1) == str.charAt(i))
                return "";
        }

        return str.toString();
    }
}
