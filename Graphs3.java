import java.util.*;

import javax.imageio.ImageIO;

import org.w3c.dom.html.HTMLDivElement;

public class Graphs3 {

    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        public Edge(int s , int d , int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }

    // public static int connectCities(int cities[][]){
    //     PriorityQueue<Edge> pq = new PriorityQueue<>();
    //     boolean vis[] = new boolean[cities.length];
    //     pq.add(new Edge(0, 0));
    //     int finalCost = 0;

    //     while(!pq.isEmpty()){
    //         Edge curr = pq.remove();
    //         if(!vis[curr.dest]){
    //             vis[curr.dest] = true;
    //             finalCost += curr.cost;

    //             for(int i = 0; i< cities[curr.dest].length; i++){
    //                 if(cities[curr.dest][i] != 0){
    //                     pq.add(new Edge(i, cities[curr.dest][i]));
    //                 }
    //             }
    //         }
    //     }
    //     return finalCost;

    // }
    static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4;  // In case of krshkal algo the value of n is vertices
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i = 0; i< n; i++){
            par[i] = i;
        }
    }


    public static int find(int x){
        if(par[x] == x){
            return x;
        }

        return find(par[x]);
    }

    public static void union(int a , int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
    }

    public static void krushkalsMST(ArrayList<Edge> edges , int V){
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for(int i = 0; count < V - 1; i++){
            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);

            if(parA != parB){
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    public static void helper(int image[][] , int sr , int sc , int color , boolean vis[][] , int orgCol){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol){
            return;
        }
        image[sr][sc] = color;
        
        // up
        helper(image, sr - 1 , sc, color, vis, orgCol);

        // down
        helper(image, sr + 1 , sc, color, vis, orgCol);

        // right
        helper(image, sr, sc + 1, color, vis, orgCol);

        // left
        helper(image, sr, sc - 1, color, vis, orgCol);
    }

    public static void floodFill(int image[][] , int sr , int sc , int color){
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image , sr , sc , color , vis , image[sr][sc]);
        for(int i = 0; i< image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // int cities[][] = {{0,1,2,3,4},
        //                     {1,0,5,0,7},
        //                     {2,5,0,6,0},
        //                     {3,0,6,0,0},
        //                     {4,7,0,0,0}};

        // System.out.println(connectCities(cities));

        // init();
        // union(1, 3);
        // System.out.println(find(3));
        // union(2, 4);
        // union(3, 6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1, 5);

        // int V = 4;
        // ArrayList<Edge> edges = new ArrayList<>();
        // createGraph(edges);
        // krushkalsMST(edges, V);

        int image[][] = {{1,1,1},
                        {1,1,0},
                        {1,0,1}};
                
        int sr = 1;
        int sc = 1;
        int color = 2;

        floodFill(image, sr, sc, color);
    }
}
