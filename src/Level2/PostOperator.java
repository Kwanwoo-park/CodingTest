package Level2;

import java.util.Scanner;

public class PostOperator {
    static int[] stack = new int[50];
    static int stackTop = -1;

    static int pop() {
        if (stackTop < 0) {
            System.out.println("Stack Underflow");
            return 1;
        }
        return stack[stackTop--];
    }

    static int push(int item) {
        if (stackTop >= 50) {
            System.out.println("Stack Overflow");
            return 1;
        }
        stack[++stackTop] = item;
        return item;
    }

    static int getStackTop() {
        if (stackTop < 0)
            return -1;
        else
            return stack[stackTop];
    }

    static boolean isStackEmpty() {
        return stackTop < 0;
    }

    static boolean isOperator(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/';
    }

    static int precedence(int op) {
        switch (op) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 3;
        }
    }

    static String postchange(String operation) {
        int idx = 0;
        String dst = new String();
        while (operation.length() >= idx+1) {
            if (operation.charAt(idx) == '(') {
                push(operation.charAt(idx));
                idx++;
            }
            else if (operation.charAt(idx) == ')') {
                while (getStackTop() != '(') {
                    dst += (char) pop();
                    dst += ' ';
                }

                pop();
                idx++;
            }
            else if (isOperator(operation.charAt(idx))) {
                while (!isStackEmpty() && precedence(getStackTop()) >= precedence(operation.charAt(idx))) {
                    dst += (char) pop();
                    dst += ' ';
                }

                push(operation.charAt(idx));
                idx++;
            }
            else if (operation.charAt(idx) >= '0' && operation.charAt(idx) <= '9') {
                do {
                    dst += operation.charAt(idx);
                    idx++;
                    if (operation.length() == idx) break;
                } while (operation.charAt(idx) >= '0' && operation.charAt(idx) <= '9');

                dst += ' ';
            }
            else {
                idx++;
            }
        }
        while (!isStackEmpty()) {
            dst += (char) pop();
            dst += ' ';
        }
        return dst;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();

        while (t-- > 0) {
            String operation = in.nextLine();

            operation = postchange(operation);

            System.out.println(operation);
        }

        in.close();
    }
}
