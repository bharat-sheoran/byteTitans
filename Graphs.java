import java.util.*;
public class Graphs {
    static class Edge{
        int src;
        int dest;
        // int wgh;

        public Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
            // this.wgh = wgh;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i< graph.length;  i++){
            if(!visited[i]){
                bfsUtil(graph, visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph , boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        // boolean[] visited = new boolean[graph.length];
        q.add(0);  // Source  == 0

        while(!q.isEmpty()){
            int curr = q.remove();

            if (!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0; i< graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i< graph.length; i++){
            dfsUtil(graph, i, visited);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph , int curr , boolean[] vis){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph , int src , int des , boolean[] vis){
        if (src == des){
            return true;
        }
        vis[src] = true;

        for(int i = 0; i< graph[src].size(); i++){
            Edge e = graph[src].get(i);

            if (!vis[e.dest] && hasPath(graph, e.dest, des, vis)){
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for(int i = 0; i< graph.length; i++){
            if(!visited[i]){
                if(detectCycleUtils(graph , visited , i , -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtils(ArrayList<Edge>[] graph , boolean visited[] , int curr , int par){
        visited[curr] = true;

        for(int i = 0; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // Case 3
            if(!visited[e.dest]){
                if(detectCycleUtils(graph, visited, e.dest, curr)){
                    return true;
                }
            }else if(visited[e.dest] && e.dest != par){        // Case 1
                return true;
            }

            // Case 2  Do nothing
        }
        return false;
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            col[i] = -1;  // NO color
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i< graph.length; i++){
            if(col[i] == -1){   // BFS
                q.add(i);
                col[i] = 0; // yellow
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j = 0; j < graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1){
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }else if(col[e.dest] == col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCycleUtils(ArrayList<Edge>[] graph , int curr , boolean vis[] , boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest]){
                if(isCycleUtils(graph, e.dest, vis, stack)){
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i = 0; i< graph.length; i++){
            if(!vis[i]){
                if(isCycleUtils(graph , i , vis , stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i< graph.length; i++){
            if(!vis[i]){
                topSortUtils(graph , i , vis , s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtils(ArrayList<Edge>[] graph , int curr , boolean vis[] , Stack<Integer> s){
        vis[curr] = true;

        for(int i = 0; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtils(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void calcIndeg(ArrayList<Edge>[] graph , int indeg[]){
        for(int i = 0; i < graph.length; i++){
            int v = i;
            for(int j = 0; j < graph[v].size(); j++){   // i means vertex
                Edge e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort1(ArrayList<Edge>[] graph){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i< indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        // BFS
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i = 0; i< graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void printAllPath(ArrayList<Edge>[] graph , int src , int dest , String path){
        if(src == dest){
            System.out.println(path + dest);
            return;
        }

        for(int i = 0; i< graph[src].size(); i++){
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src);
        }
    }



    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];   // Null ---> Empty ArrayList

        for(int i = 0; i< 6; i++){
            graph[i] = new ArrayList<>();
        }

        // graph 1 ==> True ==> cycle
        // graph[0].add(new Edge(0, 2));

        // graph[1].add(new Edge(1, 0));

        // graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 0));

        // graph 2 ==> False ==> NO cycle
        graph[2].add(new Edge(2 , 3));
        graph[3].add(new Edge(3 , 1));
        graph[4].add(new Edge(4 , 0));
        graph[4].add(new Edge(4 , 1));
        graph[5].add(new Edge(5 , 0));
        graph[5].add(new Edge(5 , 2));

        topSort1(graph);

        int src = 5 , dest = 1;
        // 2 neighbors
        // for(int i = 0; i< graph[2].size(); i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest);
        // }

        // bfs(graph);
        // dfs(graph, 0, new boolean[V]);
        // System.out.println(hasPath(graph, 0, 7, new boolean[V]));
        // System.out.println(detectCycle(graph));

        // System.out.println(isBipartite(graph));
        // System.out.println(isCycle(graph));
        // topSort(graph);

        // topSort1(graph);
        // printAllPath(graph, src, dest, "");  // Exponential time complexity

    }    
}