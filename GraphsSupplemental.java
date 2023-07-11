import java.util.*;

public class GraphsSupplemental {

    static class Edge{
        int src;
        int dest;
        Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0 , 1));
        graph[0].add(new Edge(0 , 2));
        graph[0].add(new Edge(0 , 3));

        graph[1].add(new Edge(1 , 0));
        graph[1].add(new Edge(1 , 2));

        graph[2].add(new Edge(2 , 0));
        graph[2].add(new Edge(2 , 1));

        graph[3].add(new Edge(3 , 4));

        graph[4].add(new Edge(4 , 3));
        
    }

    public static void TopSort(ArrayList<Edge> graph[] , int curr , boolean vis[] , Stack<Integer> s){
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                TopSort(graph , e.dest , vis , s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[] , int curr , boolean vis[]){
        vis[curr] = true;
        System.out.print(curr + " ");

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph , e.dest , vis);
            }
        }
    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[] , int V){
        // Step-1  => TopSort
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                TopSort(graph , i , vis , s);
            }
        }

        // Step-2 => Transponse of Graph
        ArrayList<Edge> transponse[] = new ArrayList[V];
        for(int i = 0; i < graph.length; i++){
            vis[i] = false;
            transponse[i] = new ArrayList<Edge>();
        }
        for(int i = 0; i < V; i++){
            for(int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transponse[e.dest].add(new Edge(e.dest , e.src));
            }
        }

        // Step-3 => Do DFS on Stack
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                System.out.print("SCC -> ");
                dfs(transponse , curr , vis);
                System.out.println();
            }
        }
    }

    public static void dfsTarjan(ArrayList<Edge> graph[] , int curr , int par , int dt[] , int low[] ,boolean vis[] , int time){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(e.dest == par){
                continue;
            } else if(!vis[e.dest]){
                dfsTarjan(graph, e.dest, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[e.dest]);

                if(dt[curr] < low[e.dest]){
                    System.out.println("Bridge: " + curr + "-------" + e.dest);
                }
            } else if(vis[e.dest]){
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void tarjanBridgeAlgo(ArrayList<Edge> graph[] , int V){
        int dt[] = new int[V];   // dt => Discovery Time
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfsTarjan(graph , i , -1 , dt , low , vis , time);
            }
        }
    }

    public static void dfsTarjanArti(ArrayList<Edge> graph[] , int curr , int par , int dt[] , int low[] , int time , boolean vis[] , boolean ap[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(e.dest == par){
                continue;
            }else if(vis[e.dest]){
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }else{
                dfsTarjanArti(graph, e.dest, curr, dt, low, time, vis , ap);
                low[curr] = Math.min(low[curr], low[e.dest]);

                if(par != -1 && dt[curr] <= low[e.dest]){
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1 && children > 1){
            ap[curr] = true;
        }
    }

    public static void tarjanArticulationPnt(ArrayList<Edge> graph[] , int V){
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i = 0; i < V; i++){
            dfsTarjanArti(graph , i , -1 , dt , low , time , vis , ap);
        }

        for(int i = 0; i < V; i++){
            if(ap[i]){
                System.out.println("AP: " + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // kosarajuAlgo(graph , V);
        // tarjanBridgeAlgo(graph, V);
        tarjanArticulationPnt(graph, V);
    }
}
