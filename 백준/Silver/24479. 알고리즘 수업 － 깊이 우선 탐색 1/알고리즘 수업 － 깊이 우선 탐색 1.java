
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static LinkedList<Integer>[] graph;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        int R = stoi(st.nextToken());

        result = new int[N+1];

        graph = new LinkedList[N+1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 정렬
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        dfs(R);

        for(int i = 1; i <= N; i++){
            System.out.println(result[i]);
        }

    }

    static int rank = 1;
    public static void dfs(int start){
        result[start] = rank++;


        for(int vertex : graph[start]){
            if(result[vertex]==0){
                dfs(vertex);
            }
        }

    }


    public static int stoi(String str){
        return Integer.parseInt(str);
    }

}
