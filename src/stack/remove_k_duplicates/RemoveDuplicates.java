package stack.remove_k_duplicates;

import java.util.Stack;

public class RemoveDuplicates {

    //deeedbbcccbdaa, k== 3 ==> aa
    public String remove(String str, int k){
        Stack<CharacterFreq> stack = new Stack<>();
       for(int i=0; i< str.length();i++){
           char char2 =  str.charAt(i);
           if (!stack.isEmpty()){
               if (char2 == stack.peek().char1){
                  int prev_char_count = stack.pop().freq;
                   if (prev_char_count < k-1) {
                       stack.push(new CharacterFreq(prev_char_count + 1, char2));
                   }
               } else {
                   stack.push(new CharacterFreq(1, char2));
               }
           } else {
               stack.push(new CharacterFreq(1, char2));
           }
       }

       StringBuilder result = new StringBuilder();
       while(!stack.isEmpty()){
           CharacterFreq characterFreq = stack.pop();
           for (int i=0; i<characterFreq.freq;i++){
               result.insert(0, characterFreq.char1);
           }
       }

       return result.toString();
    }

}


