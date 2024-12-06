package stack.remove_adjacent_duplicates;

import java.util.Stack;

public class RemoveAdjacentDuplicates {

//    abbaca ==> ca
    public String remove(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i< str.length(); i++){
            char char1= str.charAt(i);
            if(!stack.isEmpty() && stack.peek() == char1){
                stack.pop();
            } else {
                stack.push(char1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}
