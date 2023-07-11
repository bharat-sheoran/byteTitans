import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.*;

public class Graphs2 {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src , int dest , int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // static class Pair implements Comparable<Pair>{
    //     int n;
    //     int path;

    //     public Pair(int n , int path){
    //         this.n = n;
    //         this.path = path;
    //     }

    //     @Override
    //     public int compareTo(Pair p2){
    //         return this.path - p2.path;
    //     }
    // }

    // static class Pair implements Comparable<Pair>{
    //     int v;
    //     int cost;

    //     public Pair(int v , int cost){
    //         this.v = v;
    //         this.cost = cost;
    //     }

    //     @Override
    //     public int compareTo(Pair p2){
    //         return this.cost - p2.cost;
    //     }
    // }

    // public static void dijkstra(ArrayList<Edge> graph[] , int src){
    //     int dist[] = new int[graph.length];

    //     for(int i = 0; i < graph.length; i++){
    //         if(i != src){
    //             dist[i] = Integer.MAX_VALUE;
    //         }
    //     }

    //     boolean vis[] = new boolean[graph.length];
    //     PriorityQueue<Pair> pq = new PriorityQueue<>();
    //     pq.add(new Pair(src, 0));

    //     while(!pq.isEmpty()){
    //         Pair curr = pq.remove();

    //         if(!vis[curr.n]){
    //             vis[curr.n] = true;

    //             for(int i = 0; i< graph[curr.n].size(); i++){
    //                 Edge e = graph[curr.n].get(i);
    //                 int u = e.src;
    //                 int v = e.dest;
    //                 int w = e.wt;

    //                 if(dist[u] + w < dist[v]){
    //                     dist[v] = dist[u] + w;
    //                     pq.add(new Pair(v, dist[v]));
    //                 }
    //             }
    //         }
    //     }

    //     for(int i = 0; i< dist.length; i++){
    //         System.out.print(dist[i] + " ");
    //     }
    //     System.out.println();
    // }

    // public static void bellamFord(ArrayList<Edge>[] graph , int src){
    //     int dist[] = new int[graph.length];
    //     for(int i = 0; i< dist.length; i++){
    //         if(i != src){
    //             dist[i] = Integer.MAX_VALUE;
    //         }
    //     }

    //     int V = graph.length;
    //     for(int i = 0; i < V - 1; i++){
    //         for(int j = 0; j < graph.length; j++){
    //             for(int k = 0; k < graph[j].size(); k++){
    //                 Edge e = graph[j].get(k);
    //                 int u = e.src;
    //                 int v = e.dest;
    //                 int w = e.wt;

    //                 if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
    //                     dist[v] = dist[u] + w;
    //                 }
    //             }
    //         }
    //     }
    //     for(int i = 0; i < dist.length; i++){
    //         System.out.print(dist[i] + " ");
    //     }
    //     System.out.println();
    // }

    // public static void primsAlgo(ArrayList<Edge> graph[]){
    //     boolean vis[] = new boolean[graph.length];
    //     PriorityQueue<Pair> pq = new PriorityQueue<>();

    //     pq.add(new Pair(0, 0));
        
    //     int finalCost = 0;

    //     while(!pq.isEmpty()){
    //         Pair curr = pq.remove();
    //         if(!vis[curr.v]){
    //             vis[curr.v] = true;
    //             finalCost += curr.cost;

    //             for(int i = 0; i< graph[curr.v].size(); i++){
    //                 Edge e = graph[curr.v].get(i);
    //                 pq.add(new Pair(e.dest, e.wt));
    //             }
    //         }
    //     }
    //     System.out.println("The minimum cost of the MST is: " + finalCost);
    // }

    public static void createGraph(int flights[][] , ArrayList<Edge> graph[]){
        for(int i = 0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i< flights.length; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info{
        int v;
        int cost;
        int stops;

        public Info(int v , int c , int s){
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n , int flights[][] , int src , int dest , int k){
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n];
        for(int i = 0; i< n; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();

            if(curr.stops > k){
                break;
            }

            for(int i = 0; i< graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.cost + wt < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }
    }

    public static void main(String[] args) {
        // int V = 4;
        // ArrayList<Edge> graph[] = new ArrayList[V];

        // for(int i = 0; i< graph.length; i++){
        //     graph[i] = new ArrayList<>();
        // }

        // graph[0].add(new Edge(0, 1, 10));
        // graph[0].add(new Edge(0, 2, 15));
        // graph[0].add(new Edge(0, 3, 30));

        // graph[1].add(new Edge(1, 0, 10));
        // graph[1].add(new Edge(1, 3, 40));
        
        // graph[2].add(new Edge(2, 0, 15));
        // graph[2].add(new Edge(2, 3, 50));

        // graph[3].add(new Edge(3, 0, 30));
        // graph[3].add(new Edge(3, 1, 40));
        // graph[3].add(new Edge(3, 2, 50));

        // int src = 0;
        // dijkstra(graph, src);
        // bellamFord(graph, src);
        // primsAlgo(graph);

        int n = 4;
        int flights[][] = {{0,1,100} , {1,2,100} , {2,0,100} , {1,3,600} , {2,3,200}};
        int src = 0 , dst = 3 , k = 1;

        // System.out.println(cheapestFlight(n, flights, src, dst, k));


    }
}
