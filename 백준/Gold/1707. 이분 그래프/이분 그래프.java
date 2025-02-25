import java.io.*;
import java.util.*;

public class Main {

    static int[] color;
    static boolean canBipartiteGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = stoi(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i = 0; i < K; i++){
            canBipartiteGraph = true;
            st = new StringTokenizer(br.readLine());

            int V = stoi(st.nextToken()); // 정점 개수
            int E = stoi(st.nextToken()); // 간선 개수

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int j = 0; j < V+1; j++){
                graph.add(new ArrayList<>());
            }

            for(int j = 0; j < E; j++){
                st = new StringTokenizer(br.readLine());

                int u = stoi(st.nextToken());
                int v = stoi(st.nextToken());

                if(u==v) continue;

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            color = new int[V+1];

            for(int j = 1; j <= V; j++){
                if(!canBipartiteGraph){
                    break;
                }

                if(color[j] == 0){ // 방문 X
                    bfs(j, graph);

                }
            }

            if(canBipartiteGraph){
                sb.append("YES" + "\n");
            }else{
                sb.append("NO" + "\n");
            }

        }

        System.out.println(sb);
    }

    public static void bfs(int vertex, ArrayList<ArrayList<Integer>> graph){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(vertex);
        color[vertex] = 1;

        while(!queue.isEmpty()){
            int v = queue.poll();

            for(int node : graph.get(v)){
                if(color[node] == 0){
                    // 방문 안한 정점
                    queue.add(node);
                    color[node] = color[v] * -1; // 다른 색상으로 칠하기

                }

                else if(color[node] == color[v]){
                    // 방문 했던 정점

                    // 인접한 정점이지만 서로 같은 색상
                    canBipartiteGraph = false;
                    return;

                }
            }

        }

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}