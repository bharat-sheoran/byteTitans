import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;
import javax.print.event.PrintEvent;

public class BinarySearchTree {
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

    public static boolean search(Node root , int key){
        if (root == null){
            return false;
        }

        if (root.data == key){
            return true;
        }

        if (root.data > key){
            return search(root.left, key);
        }

        else{
            return search(root.right, key);
        }
    }

    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static Node delete(Node root , int val){
        if (root.data < val){
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{
            // Case 1 - leaf node
            if (root.left == null && root.right == null){
                return null;
            }

            // Case 2 - single child
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }

            // Case 3 - both child
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printRange(Node root , int k1 , int k2){
        if (root == null){
            return ;
        }
        if (root.data >= k1 && root.data <= k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        }else if (root.data > k2){
            printRange(root.right, k1, k2);
        }else {
            printRange(root.left, k1, k2);
        }
        
    }

    public static void printPath(ArrayList<Integer> path){
        for (int i = 0; i< path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println("N");
    }

    public static void rootLeafPath(Node root , ArrayList<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.data);

        if (root.left == null && root.right == null){
            printPath(path);
        }

        rootLeafPath(root.left , path);
        rootLeafPath(root.right , path);
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node root , Node min, Node max){
        if (root == null){
            return true;
        }

        if (min != null && root.data <= min.data){
            return false;
        }else if (max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node mirrorBST(Node root){ // O(n)
        if (root == null){
            return null;
        }
        Node leftSubTree = mirrorBST(root.left);
        Node rightSubTree = mirrorBST(root.right);

        root.left = rightSubTree;
        root.right = leftSubTree;

        return root;
    }

    public static void preOrder(Node root){
        if (root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node balancedBST(int arr[] , int start , int end){
        if (start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node root = new Node (arr[mid]);
        root.left = balancedBST(arr, start, mid - 1);
        root.right = balancedBST(arr, mid + 1, end);
        return root;
    }

    public static void getInOrder(Node root , ArrayList<Integer> inorder){
        if (root == null){
            return;
        }

        getInOrder(root.left, inorder);
        inorder.add(root.data);
        getInOrder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder , int st , int end){
        if (st > end){
            return null;
        }

        int mid = (st + end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    public static Node balancedBST1(Node root){
        // inorder Sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(root, inorder);

        // inorder sort -> balancedBST
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST , int size , int min , int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root){
        if (root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static Node mergeBSTs(Node root1 , Node root2){  // O(n + m)
        // Sorting of 1st array
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root1, arr1);
        
        // Sorting of 2nd array
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root2, arr2);

        // Merge 
        int i = 0 , j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size()){
            if (arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j < arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        // Sorted arraylist to balanced BST
        return createBST(finalArr, 0, finalArr.size() - 1);
        
    }
    public static void main(String[] args) {
        // int values[] = {8,5,3,6,10,11};
        // Node root = null;

        // for(int i = 0; i < values.length; i++){
        //     root = insert(root, values[i]);
        // }

        // inOrder(root);
        // System.out.println();

        // root = delete(root, 5);

        // inOrder(root);
        // System.out.println();
        // printRange(root, 5, 12);
        // rootLeafPath(root , new ArrayList<>());

        // System.out.println(isValidBST(root, null, null));
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.right = new Node(10);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right.right = new Node(11);

        // root = mirrorBST(root);
        // preOrder(root);

        // int arr[] = {3,5,6,8,10,11,12};
        // Node root = balancedBST(arr, 0, arr.length - 1);
        // preOrder(root);

        // Node root = new Node(8);
        // root.left = new Node(6);
        // root.left.left = new Node(5);
        // root.left.left.left = new Node(3);
        // root.right = new Node(10);
        // root.right.right = new Node(11);
        // root.right.right.right = new Node(12);

        // balancedBST1(root);
        // preOrder(root);
        
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);

        // Info info = largestBST(root);
        // System.out.println("The size of largest BST is " + maxBST);

        // Node root1 = new Node(2);
        // root1.left = new Node(1);
        // root1.right = new Node(4);

        // Node root2 = new Node(9);
        // root2.left = new Node(3);
        // root2.right = new Node(12);

        // Node root = mergeBSTs(root1, root2);
        // preOrder(root);
    }
}
