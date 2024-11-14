import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int v = stoi(st.nextToken());
            int u = stoi(st.nextToken());

            graph.get(u).add(v);
        }

        LinkedList<Integer> maxVertexes = new LinkedList<>();
        int maxCnt = 0;
        for(int i = 1; i <= N; i++){
            int cnt = hacking(i);

            if(maxCnt < cnt){
                maxCnt = cnt;

                maxVertexes.clear();
                maxVertexes.add(i);
            }else if(maxCnt == cnt){
                maxVertexes.add(i);
            }
        }

        Collections.sort(maxVertexes);

        StringBuilder sb = new StringBuilder();
        for(int v : maxVertexes){
           sb.append(v + " ");
        }

        System.out.println(sb);

    }

    public static int hacking(int start){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        int cnt = 0;

        queue.add(start);
        visited[start] = true;
        cnt++;


        while(!queue.isEmpty()){
            int vertex = queue.poll();

            ArrayList<Integer> list = graph.get(vertex);
            for(int v : list){
                if(!visited[v]){
                    queue.add(v);
                    visited[v] = true;
                    cnt++;
                }
            }
        }


        return cnt;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}