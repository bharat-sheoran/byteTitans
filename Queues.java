import java.util.*;

import javax.lang.model.element.Element;

public class Queues {

    // // static class Node{
    // //     int data;
    // //     Node next;

    // //     Node(int data){
    // //         this.data = data;
    // //         this.next = null;
    // //     }
    // // }

    // // static class Queue{
    // // //     // static int arr[];      // Queue using array
    // // //     // static int size;
    // // //     // static int rear;
    // // //     // static int front;      // for Circular array queue

    // // //     // Queue(int n){
    // // //     //     arr = new int[n];
    // // //     //     size = n;
    // // //     //     rear = -1;
    // // //     //     front = -1;
    // // //     // }

    // // //     static Node head = null;
    // // //     static Node tail = null;
        
        
    // // //     // Is empty 
    // // //     public static boolean isEmpty(){
    // // //         // return rear == -1 && front == -1;  // for arrays
    // // //         return head == null && tail == null;  // for linked list
    // // //     }

    // // //     // is full
    // // //     // public static boolean isFull(){
    // // //     //     return (rear + 1) % size == front;   // For circular linked list
    // // //     // }
        
    // // //     // Add function    
    // // //     public static void add(int data){     // O(1)
    // // //         // if (isFull()){
    // // //         //     System.out.println("Queue is full");
    // // //         //     return;
    // // //         // }

    // // //         // For arrays 
    // // //         // if (front == -1){
    // // //         //     front = 0;
    // // //         // }
    // // //         // // rear++; 
    // // //         // rear = (rear + 1) % size;   // for circular array
    // // //         // arr[rear] = data;

    // // //         // For linked list
    // // //         Node newNode = new Node(data);
    // // //         if (head == null){
    // // //             head = tail = newNode;
    // // //         }
    // // //         tail.next = newNode;
    // // //         tail = newNode;
    // // //     }
        
    // // //     // Remove function

    // // //     public static int remove(){   // O(n)
    // // //         if (isEmpty()){
    // // //             System.out.println("The Queue is already empty");
    // // //             return -1;
    // // //         }

    // // //         // For arrays
    // // //         // int result = arr[front];

            
    // // //         // // rear--;
            
    // // //         // // Last element delete
    // // //         // if (rear == front){
    // // //         //     rear = front = -1;
    // // //         // }else{
    // // //         //     front = (front + 1) % size;
    // // //         // }
    // // //         // return result;

    // // //         // For linkedlist
    // // //         int front = head.data;
    // // //         if(tail == head){
    // // //             head = tail = null;
    // // //         }else{
    // // //             head = head.next;
    // // //         }

    // // //         return front;
    // // //     }
        
    // // //     // Peek function
    // // //     public static int peek(){
    // // //         if (isEmpty()){
    // // //             System.out.println("The Queue is already empty");
    // // //             return -1;
    // // //         }
    // // //         // return arr[front];      // In case of arrays
    // // //         return head.data;    // In case of linked list
    // // //     }

    // //     // Queue using two stacks
    // //     static Stack<Integer> s1 = new Stack<>();
    // //     static Stack<Integer> s2 = new Stack<>();

    // //     public static boolean isEmpty(){
    // //         return s1.isEmpty();
    // //     }

    // //     // add
    // //     public static void add(int data){
    // //         while(!s1.isEmpty()){
    // //             s2.push(s1.pop());
    // //         }

    // //         s1.push(data);

    // //         while(!s2.isEmpty()){
    // //             s1.push(s2.pop());
    // //         }
    // //     }

    // //     // Remove 
    // //     public static int remove(){
    // //         while(isEmpty()){
    // //             System.out.println("Queue is empty");
    // //             return -1;
    // //         }
    // //         return s1.pop();
    // //     }

    // //     // peek 
    // //     public static int peek(){
    // //         while(isEmpty()){
    // //             System.out.println("Queue is empty");
    // //             return -1;
    // //         }
    // //         return s1.peek();
    // //     }
    // // }

    // // static class Stack{
    // //     static Queue<Integer> q1 = new LinkedList<>();
    // //     static Queue<Integer> q2 = new LinkedList<>();

    // //     public static boolean isEmpty(){
    // //         return q1.isEmpty() && q2.isEmpty();
    // //     }

    // //     public static void push(int data){
    // //         if(!q1.isEmpty()){
    // //             q1.add(data);
    // //         }else{
    // //             q2.add(data);
    // //         }
    // //     }

    // //     public static int pop(){
    // //         if (isEmpty()){
    // //             System.out.println("Queue is Empty");
    // //             return -1;
    // //         }
    // //         int top = -1;
    // //         if (!q1.isEmpty()){  // Case 1   q1 k andr saare elements h
    // //             while(!q1.isEmpty()){
    // //                 top = q1.remove();
    // //                 if (q1.isEmpty()){
    // //                     break;
    // //                 }
    // //                 q2.add(top);
    // //             }
    // //         }else{  // Case 2    q2 k andr saare elements h
    // //             while(!q2.isEmpty()){
    // //                 top = q2.remove();
    // //                 if (q2.isEmpty()){
    // //                     break;
    // //                 }
    // //                 q1.add(top);
    // //             }
    // //         }
    // //         return top;
    // //     }

    // //     public static int peek(){
    // //         if (isEmpty()){
    // //             System.out.println("Queue is Empty");
    // //             return -1;
    // //         }
    // //         int top = -1;
    // //         if (!q1.isEmpty()){  // Case 1   q1 k andr saare elements h
    // //             while(!q1.isEmpty()){
    // //                 top = q1.remove();
    // //                 q2.add(top);
    // //             }
    // //         }else{  // Case 2    q2 k andr saare elements h
    // //             while(!q2.isEmpty()){
    // //                 top = q2.remove();
    // //                 q1.add(top);
    // //             }
    // //         }
    // //         return top;
    // //     }
    // // }


    // public static void nonRepeating(String str){
    //     int freq[] = new int[26];
    //     Queue<Character> q = new LinkedList<>();

    //     for (int i = 0; i < str.length(); i++){
    //         char ch = str.charAt(i);
    //         q.add(ch);
    //         freq[ch - 'a']++;

    //         while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
    //             q.remove();
    //         }
    //         if(q.isEmpty()){
    //             System.out.print(-1 + " ");
    //         }else{
    //             System.out.print(q.peek() + " ");
    //         }
    //     }
    //     System.out.println();
    // }

    // public static void interLeave(Queue<Integer> q){
    //     Queue<Integer> firstHalf = new LinkedList<>();
    //     int size = q.size();

    //     for (int i = 0; i < size/2; i++){
    //         firstHalf.add(q.remove());
    //     }

    //     while(!firstHalf.isEmpty()){
    //         q.add(firstHalf.remove());
    //         q.add(q.remove());
    //     }
    // }

    // public static void reverse(Queue<Integer> q){
    //     Stack<Integer> s = new Stack<>();

    //     while(!q.isEmpty()){
    //         s.push(q.remove());
    //     }

    //     while(!s.isEmpty()){
    //         q.add(s.pop());
    //     }
    // }

    static class Stack{
        Deque<Integer> deque = new LinkedList<>();

        // Push 
        public void push(int data){
            deque.addLast(data);
        }
        // pop
        public int pop(){
            return deque.removeLast();
        }

        // peek
        public int peek(){
            return deque.getLast();
        }
    }
    public static void main(String[] args) {
        // Queue q = new Queue(); 
        // Queue<Integer> q = new LinkedList<>();   // Through JCF   // ArrayDeque can also be used instead of LinkedList
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // // System.out.println(q.remove());
        // q.add(4);
        // // System.out.println(q.remove());
        // q.add(5);

        // while (!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // String str = "aabccxb";
        // nonRepeating(str);

        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);

        // // interLeave(q);
        // reverse(q);
        // while(!q.isEmpty()){
        //     System.out.print(q.remove() + " ");
        // }
        // System.out.println();

        // Deque<Integer> dq = new LinkedList<>();
        // dq.addFirst(1);
        // dq.addFirst(2);
        // dq.addLast(3);
        // dq.addLast(4);
        // System.out.println(dq);
        // dq.remove();
        // System.out.println(dq);

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
