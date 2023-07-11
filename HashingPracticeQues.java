import java.util.*;
public class HashingPracticeQues {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class Info{
        Node node;
        int hd;

        Info(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void bottomView(Node root){
        if (root == null){
            return;
        }

        Queue<Info> q = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();
        int min = 0;
        int max = 0;

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
                map.put(curr.hd , curr.node);

                if (curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for(int i = min; i <= max; i++){
            System.out.print(map.get(i).data + " ");
        }
    }

    public static int[] sumTwo(int arr[] , int target){
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i = 0; i< arr.length; i++){
            int diff = target - arr[i];

            if (map.containsKey(diff)){
                return new int[]{i , map.get(diff)};
            }

            map.put(arr[i] , i);
        }
        return new int[] {0,0};
    }

    public static void frequenctySort(String s){
        HashMap<Character , Integer> map = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        
    }
    public static void main(String[] args) {
        
        // Node root = new Node(20);
        // root.left = new Node(8);
        // root.right = new Node(22);
        // root.right.right = new Node(25);
        // root.left.left = new Node(5);
        // root.left.right = new Node(3);
        // root.left.right.left = new Node(10);
        // root.left.right.right = new Node(14);

        // bottomView(root);

        // int arr[] = {2,7,11,15};
        // int target = 9;
        // int ans[] = sumTwo(arr, target);

        // for(int i = 0; i< ans.length; i++){
        //     System.out.println(ans[i]);
        // }

        String s = "tree";
    }
}
