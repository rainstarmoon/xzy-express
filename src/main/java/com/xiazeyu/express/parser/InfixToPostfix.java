package com.xiazeyu.express.parser;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> operatorStack = new Stack<String>();
        String tmp ="2*3/(2-1)+3*(4-1)";// 23*21-/341-*+   // 23*21-/341-*+
        String[] split = tmp.split("");

        for (int j=0;j<split.length;j++){
            String str =split[j];
            if (str.equals("("))
                operatorStack.push(str);
            else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                boolean isEmpty;
                boolean isLeftParen;
                boolean isLowerOperator;
                isEmpty = operatorStack.isEmpty();
                isLeftParen = false;
                isLowerOperator = false;
                if (!isEmpty) {
                    String stackTop = operatorStack.peek();
                    isLeftParen = operatorStack.peek().equals("(");
                    if ((stackTop.equals("+") || stackTop.equals("-")) && (str.equals("*") || str.equals("/"))) {
                        isLowerOperator = true;
                    }
                }
                if (!(isEmpty || isLeftParen || isLowerOperator)) {
                    for (int i = 0; i < operatorStack.size(); i++) {
                        System.out.print(operatorStack.pop());
                    }
                }
                operatorStack.push(str);
            } else if (str.equals(")")) {
                String pop = operatorStack.pop();
                while (!pop.equals("(")) {
                    System.out.print(pop);
                    pop = operatorStack.pop();
                }
            } else {
                System.out.print(str);
            }
        }
        int num = operatorStack.size();
        while(num-->0){
            String pop = operatorStack.pop();
            System.out.print(pop);
        }
    }
}