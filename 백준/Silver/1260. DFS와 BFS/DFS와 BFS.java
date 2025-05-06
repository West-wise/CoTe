import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        ArrayList<Integer> visited1 = new ArrayList<>();
        ArrayList<Integer> visited2 = new ArrayList<>();

        for(int i =1; i<=N;i++){
            graph.put(i,new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int key : graph.keySet()){
            Collections.sort(graph.get(key));
        }

        dfs(graph,V,visited1);
        System.out.println();
        bfs(graph,V,visited2);
    }

    static void dfs(HashMap<Integer, ArrayList<Integer>> graph, int start, ArrayList<Integer> visited) {
        System.out.print(start + " ");
        visited.add(start);
        for (int key : graph.get(start)) {
            if (!visited.contains(key)) {
                dfs(graph, key, visited);
            }
        }
    }

    static void bfs(HashMap<Integer, ArrayList<Integer>> graph, int start, ArrayList<Integer> visited){
        System.out.printf(start + " ");
        visited.add(start);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            for (int node : graph.get(queue.poll())) {
                if (!visited.contains(node)) {
                    System.out.printf(node + " ");
                    visited.add(node);
                    queue.add(node);
                }
            }
        }
    }
}