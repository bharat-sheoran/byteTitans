import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.StyledEditorKit.BoldAction;

public class GraphsPracticeQues {

    // static class Edge{
    //     int src;
    //     int dest;

    //     public Edge(int src , int dest){
    //         this.src = src;
    //         this.dest = dest;
    //     }
    // }

    // static class Node{
    //     int data;
    //     Node left , right;

    //     public Node(int data){
    //         this.data = data;
    //         this.left = null;
    //         this.right = null;
    //     }
    // }

    // static class Info{
    //     Node node;
    //     int depth;

    //     public Info(Node node , int depth){
    //         this.node = node;
    //         this.depth = depth;
    //     }
    // }

    // public static int minDist(Node root){
    //     if(root == null){
    //         return 0;
    //     }

    //     Queue<Info> q = new LinkedList<>();
    //     q.add(new Info(root, 0));

    //     while(!q.isEmpty()){
    //         Info curr = q.remove();

    //         Node node = curr.node;
    //         int depth = curr.depth;

    //         if(node.left == null && node.right == null){
    //             return depth;
    //         }

    //         if(node.left != null){
    //             curr.node = node.left;
    //             curr.depth++;
    //             q.add(curr);
    //         }

    //         if(node.right != null){
    //             curr.node = node.right;
    //             curr.depth++;
    //             q.add(curr);
    //         }
    //     }
    //     return 0;
    // }

    // public static boolean detectCycleUtils(ArrayList<Edge>[] graph , boolean visited[] , int curr , int par){
    //     Queue<Integer> q = new LinkedList<>();
    //     visited[curr] = true;
    //     q.add(curr);

    //     while(!q.isEmpty()){
    //         curr = q.remove();
    //         for(int i = 0; i< graph[curr].size(); i++){
    //             Edge e = graph[curr].get(i);
    //             if(!visited[e.dest]){
    //                 if(q.add(e.dest) == true){
    //                     return true;
    //                 }
    //             }else if(visited[e.dest] && e.dest != par){
    //                 return true;
    //             }
    //         }

    //     }
    //     return false;
    // }

    // public static boolean detectCycle(ArrayList<Edge>[] graph){
    //     boolean visited[] = new boolean[graph.length];
    //     for(int i = 0; i< graph.length; i++){
    //         if(!visited[i]){
    //             if(detectCycleUtils(graph , visited , i , -1)){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }


    public static void main(String[] args) {
        // int V = 10;
        // ArrayList<Edge>[] graph = new ArrayList[V];

        // for(int i = 0; i< graph.length; i++){
        //     graph[i] = new ArrayList<>();
        // }

        // graph[1].add(new Edge(1, 9));
        // graph[1].add(new Edge(1, 5));

        // graph[2].add(new Edge(2, 5));
        // graph[2].add(new Edge(2, 4));

        // graph[4].add(new Edge(4, 2));

        // graph[5].add(new Edge(5, 9));
        // graph[5].add(new Edge(5, 1));
        // graph[5].add(new Edge(5, 2));

        // graph[9].add(new Edge(9, 5));
        // graph[9].add(new Edge(9, 1));

        // System.out.println(detectCycle(graph));

        // Node root = new Node(1);
        // root.left = new Node(8);
        // root.left.left = new Node(6);
        // root.left.right = new Node(5);
        
        // root.right = new Node(2);
        // root.right.left = new Node(9);

        // System.out.println(minDist(root));

    }
}
