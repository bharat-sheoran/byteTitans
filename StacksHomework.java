import java.util.*;

public class StacksHomework {

    static class Node {
        int data;
        Node next;

        Node (int data){
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPallindrome(Node head) {
        Node slow = head;
        boolean isPallin = true;

        Stack<Integer> s = new Stack<>();

        while(slow != null){
            s.push(slow.data);
            slow = slow.next;
        }
        while(head != null){
            int i = s.pop();
            if (head.data == i){
                isPallin =  true;
            }else{
                isPallin = false;
                break;
            }
            head = head.next;
        }
        return isPallin;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = null;

        System.out.println(isPallindrome(one));
    }
}
