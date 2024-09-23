import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        //그래프 초기화
        for(int i = 0; i < N+1; i++){
            graph.add(new LinkedList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int cnt = 0;

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                cnt++;
            }

        }

        System.out.print(cnt);

    }

    public static void dfs(int vertex){
        LinkedList<Integer> list = graph.get(vertex);
        visited[vertex] = true;

        for(int j = 0; j < list.size(); j++){
            if(!visited[list.get(j)]){
                dfs(list.get(j));
            }
        }
    }
}