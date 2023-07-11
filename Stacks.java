import java.util.ArrayList;
import java.util.*;

public class Stacks {
    // static class Node {
    //     // Stacks using linked list
    //     int data;
    //     Node next;

    //     Node (int data){
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // static class Stack{
        // Stacks using Array List ====>
        
        // static ArrayList<Integer> list = new ArrayList<>();
        // public static boolean isEmpty(){   // Is empty function
        //     return list.size() == 0;
        // }

        // // Push function 
        // public static void push(int data){
        //     list.add(data);
        // }

        // // Pop function
        // public static int pop() {
        //     if (isEmpty()){
        //         return -1;
        //     }
        //     int top = list.get(list.size() - 1);
        //     list.remove(list.size() - 1);
        //     return top;
        // }

        // // Peek function
        // public static int Peek() {
        //     if (isEmpty()){
        //         return -1;
        //     }
        //     return list.get(list.size() - 1);
        // }  <=====


        // Stacks Using Linked List ====>
        

        // static Node head;

        // // IsEmpty function
        // public static boolean isEmpty(){
        //     return head == null;
        // }

        // // Push function 
        // public static void push(int data){
        //     Node newNode = new Node(data);
        //     if (isEmpty()){
        //         head = newNode;
        //         return;
        //     }

        //     newNode.next = head;
        //     head = newNode;
        // }

        // // pop function
        // public static int pop(){
        //     if (isEmpty()){
        //         return -1;
        //     }

        //     int top = head.data;
        //     head = head.next;
        //     return top;
        // }

        // // Peek function
        // public static int peek(){
        //     if (isEmpty()){
        //         return -1;
        //     }

        //     return head.data;
        // }
    // }


    // Push the element in bottom of the stack
    public static void pushBottom(Stack<Integer> s , int data){
        if (s.isEmpty()){
            s.push(data);
            return;
        }
        
        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    // Reverse the stack
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s){
        if (s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        reverseStack(s);
        pushBottom(s, top);
    }

    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void stockSpan(int stocks[] , int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1 ; i < stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if (s.isEmpty()){
                span[i] = i + 1;
            }else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static boolean isInvalid(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }else{
                if (s.isEmpty()){
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if (s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            // closing loop
            if (ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if (count < 1){
                    return true;
                }else{
                    s.pop();
                }
            }else{  // Opening statement
                s.push(ch);
            }
        }
        return false;
    }

    // Max area in an histogram
    public static int maxAreaHistogram(int heights[]){   // O(n)
        int maxArea = 0;
        Stack<Integer> s = new Stack<>();
        // nsl 
        int nxtSmallerleft[] = new int[heights.length];

        for (int i = 0; i <= heights.length - 1; i++){
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }if (s.isEmpty()){
                nxtSmallerleft[i] = -1;
            }else{
                nxtSmallerleft[i] = s.peek();
            }

            s.push(i);
        }

        // nsr
        s = new Stack<>();
        int nxtSmallerright[] = new int[heights.length];

        for (int i = heights.length - 1; i >= 0 ; i--){
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }if (s.isEmpty()){
                nxtSmallerright[i] = heights.length;
            }else{
                nxtSmallerright[i] = s.peek();
            }

            s.push(i);
        }

        // Current area :  width = j - i - 1   nsr[i] - nsl[i] - 1
        for (int i = 0; i < heights.length; i++){
            int height = heights[i];
            int width = nxtSmallerright[i] - nxtSmallerleft[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }
    
    public static void main(String args[]) {
        // Stack s = new Stack();
        
        // Stack<Integer> s = new Stack<>();  // Java Collection framework
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }\

        // pushBottom(s, 4);
        // while (!s.isEmpty()){
        //     System.out.println(s.pop());
        // }

        // String str = "KEEPA";
        // System.out.println(reverseString(str));

        // Stack<Integer> s = new Stack<>();
        // s.push(3);
        // s.push(2);
        // s.push(1);

        // reverseStack(s);
        // printStack(s);

        // Stock span problem
        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks , span);

        // for (int i = 0; i < span.length; i++){
        //     System.out.print(span[i] + " ");
        // }

        // Next greater element
        // int arr[] = {6,8,0,1,3};
        // Stack<Integer> s = new Stack<>();
        // int nxtGreater[] = new int[arr.length];

        // for (int i = arr.length - 1; i >= 0; i--){
        //     // while 
        //     while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
        //         s.pop();
        //     }

        //     // if else
        //     if (s.isEmpty()){
        //         nxtGreater[i] = -1;
        //     }else{
        //         nxtGreater[i] = arr[s.peek()];
        //     }

        //     // push element
        //     s.push(i);
        // }
        // for(int i = 0; i < nxtGreater.length; i++){
        //     System.out.print(nxtGreater[i] + " ");
        // }
        // System.out.println();

        // Next greater right
        // Next greater left
        // Next smaller right
        // Next smaller Left

        // String str = "({})[]";  // true
        // System.out.println(isInvalid(str));

        // String str = "((a + b))";
        // String str2 = "(a - b)";
        // System.out.println(isDuplicate(str2));

        int heights[] = {2,1,5,6,2,3};
        System.out.println(maxAreaHistogram(heights));
    }
}