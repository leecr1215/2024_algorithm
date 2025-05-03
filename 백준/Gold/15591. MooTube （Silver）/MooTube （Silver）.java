import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static LinkedList<Node>[] graph;

    public static class Node{
        int num;
        int USADO;

        public Node(int num, int USADO){
            this.num = num;
            this.USADO = USADO;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // 동영상 개수
        int Q = stoi(st.nextToken());

        graph = new LinkedList[N+1];

        for(int i = 0; i <= N; i++){
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());

            int p = stoi(st.nextToken());
            int q = stoi(st.nextToken());
            int r = stoi(st.nextToken());

            graph[p].add(new Node(q, r));
            graph[q].add(new Node(p, r));

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());

            int k = stoi(st.nextToken());
            int v = stoi(st.nextToken());

            bw.write(getRecommandVideoNumber(k, v) + "\n");
        }


        bw.flush();
        bw.close();
    }

    public static int getRecommandVideoNumber(int k, int v){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();

        int cnt = 0;

        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            int video = queue.poll();

            for(Node node : graph[video]){
                if(!visited[node.num] && node.USADO >= k){
                    queue.add(node.num);
                    visited[node.num] = true;
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
