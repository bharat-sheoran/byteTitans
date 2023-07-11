import java.util.ArrayList;

public class AVL_Trees {

    static class Node {
        int data , height;
        Node left , right;

        Node (int data){
            this.data = data;
            this.height = 1;
        }
    }

    public static Node root;

    public static int height(Node root){
        if (root == null){
            return 0;
        }
        return root.height;
    }

    public static int getBalanceFactor(Node root){
        if (root == null){
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    public static Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    public static Node rightRotate(Node y){
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update Height
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return x;
    } 

    public static Node insert(Node root , int val){
        if (root == null){
            return new Node(val);
        }

        if (root.data > val){
            root.left = insert(root.left, val);
        }else if (root.data < val){
            root.right = insert(root.right, val);
        }else{
            return root;
        }
        
        // Update the height 
        root.height = Math.max(height(root.left), height(root.right));

        int bf = getBalanceFactor(root);

        // left left case
        if (bf > 1 && val < root.left.data){
            return rightRotate(root);
        }

        // Right right Case
        if (bf < -1 && val > root.right.data){
            return leftRotate(root);
        }

        // Left right case
        if (bf > 1 && val > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right left case
        if (bf < -1 && val < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

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
    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrder(root);
    }
}
