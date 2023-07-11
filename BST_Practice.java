import java.util.ArrayList;

public class BST_Practice {

    static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node insert(Node root , int val){
        if (root == null){
            root = new Node(val);
            return root;
        }

        if (root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root , ArrayList<Integer> arr1){
        if (root == null){
            return;
        }

        inOrder(root.left , arr1);
        arr1.add(root.data);
        inOrder(root.right , arr1);
    }

    public static void sumOfNode(ArrayList<Integer> arr1 , int L , int R){
        int sum = 0;

        for (int i = 0; i< arr1.size(); i++){
            if (arr1.get(i) >= L && arr1.get(i) <= R){
                sum += arr1.get(i);
            }
        }
        System.out.print(sum);
    }

    public static void nearestDiff(Node root , int k){
        int mindiff = Integer.MAX_VALUE;
        int diff;
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root, arr);

        for (int i = 0; i < arr.size(); i++){
            diff = arr.get(i) - k;
            mindiff = Math.abs(Math.min(diff, mindiff));
        }
        int val = mindiff + k;
        System.out.println(val + " (The difference is " + mindiff + ")");
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,6,11,20};
        Node root = null;
        for (int i = 0; i< values.length; i++){
            root = insert(root, values[i]);
        }

        // ArrayList<Integer> arr1 = new ArrayList<>();
        // inOrder(root , arr1);

        // sumOfNode(arr1, 3, 6);
        nearestDiff(root, 5);
    }
}