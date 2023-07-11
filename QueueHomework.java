import java.util.*;
public class QueueHomework {
    // Generate Binary number
    public static void printBinary(int n){
        Queue<String> q = new LinkedList<>();
        q.add("1");

        while(n-- > 0){
            String s1 = q.peek();
            q.remove();
            System.out.print(s1 + " ");
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }
    }

    public static int minCost(int size , int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }

        int res = 0;
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            res += first + second;
            pq.add(first + second);
        }
        return res;
    }

    public static void main(String[] args) {
        // printBinary(100);
        int arr[] = {1,2,3};
        int size = arr.length;

        System.out.print(minCost(size, arr));
    }
}
