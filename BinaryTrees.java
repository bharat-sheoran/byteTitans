import java.lang.System.Logger.Level;
import java.text.BreakIterator;
import java.time.chrono.HijrahEra;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class BinaryTrees {

    static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // static class BinaryTree{    // O(n)
    //     static int idx = -1;
    //     public static Node buildTree(int nodes[]){
    //         idx++;
    //         if (nodes[idx] == -1){
    //             return null;
    //         }

    //         Node newNode = new Node(nodes[idx]);
    //         newNode.left = buildTree(nodes);
    //         newNode.right = buildTree(nodes);

    //         return newNode;
    //     }
    //     public static void preOrder(Node root){    // O(n)
    //         if (root == null){
    //             // System.out.print(-1 + " ");
    //             return;
    //         }
    //         System.out.print(root.data + " ");
    //         preOrder(root.left);
    //         preOrder(root.right);
    //     }

    //     public static void inOrder(Node root){
    //         if (root == null){
    //             return;
    //         }
    //         inOrder(root.left);
    //         System.out.print(root.data + " ");
    //         inOrder(root.right);
    //     }

    //     public static void postOrder(Node root){
    //         if (root == null){
    //             return;
    //         }
    //         postOrder(root.left);
    //         postOrder(root.right);
    //         System.out.print(root.data + " ");
    //     }

    //     public static void levelOrder(Node root){
    //         if (root == null){
    //             return;
    //         }

    //         Queue<Node> q = new LinkedList<>();
    //         q.add(root);
    //         q.add(null);

    //         while(!q.isEmpty()){
    //             Node currNode = q.remove();
    //             if (currNode == null){
    //                 System.out.println();
    //                 if (q.isEmpty()){
    //                     break;
    //                 }else{
    //                     q.add(null);
    //                 }
    //             }else{
    //                 System.out.print(currNode.data + " ");
    //                 if (currNode.left != null){
    //                     q.add(currNode.left);
    //                 }
    //                 if (currNode.right != null){
    //                     q.add(currNode.right);
    //                 }
    //             }
    //         }
    //     }
    // }

    // public static int treeHeight(Node root){
    //     if (root == null){
    //         return 0;
    //     }
            
    //     int lh = treeHeight(root.left);
    //     int rh = treeHeight(root.right);
    //     int height = Math.max(lh, rh) + 1;
    //     return height;
    // }

    // public static int totalNodes(Node root){
    //     if (root == null){
    //         return 0;
    //     }
    //     int LC = totalNodes(root.left);
    //     int RC = totalNodes(root.right);
    //     int count = LC + RC + 1;
    //     return count;
    // }

    // public static int sumNodes(Node root){
    //     if (root == null){
    //         return 0;
    //     }
    //     int LS = sumNodes(root.left);
    //     int RS = sumNodes(root.right);
    //     int sum = LS + RS + root.data;
    //     return sum;
    // }

    // public static int diameter(Node root){   // O(n^2)
    //     if (root == null){
    //         return 0;
    //     }

    //     int LDiam = diameter(root.left);
    //     int LHt = treeHeight(root.left);
    //     int RDiam = diameter(root.right);
    //     int RHt = treeHeight(root.right);

    //     int selfDiam = LHt + RHt + 1;

    //     return Math.max(selfDiam, Math.max(LDiam, RDiam));
    // }

    // static class Info{
    //     int diam;
    //     int ht;
        
    //     public Info(int diam , int ht){
    //         this.diam = diam;
    //         this.ht = ht;
    //     }
    // }

    // public static Info diameter2(Node root){  // O(n)
    //     if (root == null){
    //         return new Info(0, 0);
    //     }
    //     Info leftInfo = diameter2(root.left);
    //     Info rightInfo = diameter2(root.right);

    //     int diam = Math.max(leftInfo.diam, Math.max(rightInfo.diam, (leftInfo.ht+ rightInfo.ht + 1)));
    //     int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1; 
    //     return new Info(diam, ht);
    // }

    // public static boolean isIdentical(Node node , Node subRoot){
    //     if (node == null && subRoot == null){
    //         return true;
    //     }else if (node == null || subRoot == null || node.data != subRoot.data){
    //         return false;
    //     }

    //     if (!isIdentical(node.left, subRoot.left)){
    //         return false;
    //     }
    //     if (!isIdentical(node.right, subRoot.right)){
    //         return false;
    //     }

    //     return true;
    // }

    // public static boolean isSubTree(Node root , Node subRoot){
    //     if (root == null){
    //         return false;
    //     }
    //     if (root.data == subRoot.data){
    //         if (isIdentical(root , subRoot)){
    //             return true;
    //         }
    //     }
    //     return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    // }

    static class Info{
        Node node;
        int hd;

        public Info(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root){
        // Level order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if (curr == null){
                if (q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if (!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                
                if (curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min , curr.hd - 1);
                }
                
                if (curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max , curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++){
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void kLevel(Node root , int level , int k){
        if (root == null){
            return;
        }

        if (level == k){
            System.out.print(root.data + " ");
            return;
        }

        kLevel(root.left, level + 1, k);
        kLevel(root.right, level + 1, k);
    }

    public static boolean getPath(Node root , int n , ArrayList<Node> path){
        if (root == null){
            return false;
        }
        path.add(root);

        if (root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight){
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static Node lcaApr1(Node root , int n1 , int n2){  // O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1 , path1);
        getPath(root, n2 , path2);

        int i = 0;
        for (i = 0 ; i < path1.size() && i < path2.size(); i++){
            if (path1.get(i) != path2.get(i)){
                break;
            }
        }

        Node lca = path1.get(i - 1);
        return lca;
    }

    public static Node lcaApr2(Node root , int n1 , int n2){    // O(n)
        if (root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lcaApr2(root.left, n1, n2);
        Node rightlca = lcaApr2(root.right, n1, n2);

        // Leftlca = valid but rightlca = null
        if (rightlca == null){
            return leftlca;
        }

        if (leftlca == null){
            return rightlca;
        }

        return root;
    }

    public static int lcaDist(Node root , int n){
        if (root == null){
            return -1;
        }
        if (root.data == n){
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);
        
        if (leftDist == -1 && rightDist == -1){
            return -1;
        }else if (leftDist == -1){
            return rightDist + 1;
        }else{
            return leftDist + 1;
        }
    }

    public static int minDist(Node root , int n1 , int n2){
        Node lca = lcaApr2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int kthAncestor(Node root , int k , int node){
        if (root == null){
            return -1;
        }

        if (root.data == node){
            return 0;
        }

        int leftDist = kthAncestor(root.left, k, node);
        int rightDist = kthAncestor(root.right, k, node);

        if (leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k){
            System.out.println(root.data + " ");
        }
        return max + 1;

    }

    public static int sumTree(Node root){
        if (root == null){
            return 0;
        }

        int leftChild = sumTree(root.left);
        int rightChild = sumTree(root.right);

        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + rightChild;

        return data;
    }

    public static void preOrder(Node root){
        if (root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static boolean isUnival(Node root){
        if (root == null){
            return true;
        }

        if (root.left != null && root.left.data != root.data){
            return false;
        }

        if (root.right != null && root.right.data != root.data){
            return false;
        }

        return isUnival(root.left) && isUnival(root.right);
    }

    public static Node mirror(Node root){
        if (root == null){
            return root;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void viewOrder(Node root){
        if (root == null){
            return;
        }

        viewOrder(root.left);
        System.out.print(root.data + " ");

        viewOrder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        // tree.levelOrder(root);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // System.out.println(treeHeight(root));
        // System.out.println(totalNodes(root));
        // System.out.println(sumNodes(root));
        // System.out.println(diameter(root));
        // System.out.println(diameter2(root).ht);
        // System.out.println(isSubTree(root, subRoot));
        // topView(root);
        // kLevel(root, 1, 4);
        // System.out.println(lcaApr1(root, 4, 5).data);
        // System.out.println(lcaApr2(root, 4, 5).data);
        // System.out.println(minDist(root, 4, 6));
        // kthAncestor(root,1, 4);
        // sumTree(root);
        // preOrder(root);

        // System.out.println(isUnival(root));
        // mirror(root);
        // viewOrder(root);

    }
}
