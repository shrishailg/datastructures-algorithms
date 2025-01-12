package stack;

import java.util.Stack;

public class MinRemoveToMakeValidParenthesis {

    public static void main(String[] args) {
        String str = "m)no(q)rs(";
        System.out.println(remove(str));
    }

    public static String remove(String str) {
        Stack<Node> stack = new Stack<>();
        char[] sArray = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);

            if (!stack.isEmpty() && stack.peek().character == '(' && val == ')') {
                stack.pop();
            } else if (val == '(' || val == ')') {
                stack.push(new Node(i, val));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            sArray[stack.pop().index] = ' ';
        }

        for (char c : sArray) {
            if (c != ' ') {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

    public static class Node {
        int index;
        char character;

        public Node(int index, char character) {
            this.index = index;
            this.character = character;
        }
    }
}
