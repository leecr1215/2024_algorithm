import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[N+1];

        for(int i = 0; i < N+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 그래프 정렬
        for(int i = 0; i < N+1; i++){
            Collections.sort(graph.get(i));
        }

        dfs(V);

        sb.append("\n");
        Arrays.fill(visited, false);

        bfs(V);

        System.out.println(sb.toString());
    }

    public static void dfs(int vertex){
        visited[vertex] = true;
        ArrayList<Integer> list = graph.get(vertex);
        sb.append(vertex + " ");

        for(int v : list){
            if(!visited[v]){
                dfs(v);
            }
        }
    }

    public static void bfs(int startVertex){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startVertex);
        visited[startVertex] = true;
        sb.append(startVertex + " ");

        while(!queue.isEmpty()){
            int vertex = queue.poll();

            ArrayList<Integer> list = graph.get(vertex);
            for(int v : list){
                if(!visited[v]){
                    queue.add(v);
                    visited[v] = true;
                    sb.append(v + " ");
                }
            }
        }

    }

}