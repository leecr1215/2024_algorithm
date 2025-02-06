import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new LinkedList<>());
        }

        int[] inDegree = new int[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());

            graph.get(A).add(B);
            inDegree[B]++;
        }

        topologicalSort(N, inDegree, graph);

    }

    public static void topologicalSort(int N, int[] inDegree, LinkedList<LinkedList<Integer>> graph)throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int height = queue.poll();
            bw.write(height + " ");

            for(int h : graph.get(height)){
                inDegree[h]--;

                if(inDegree[h]==0){
                    queue.add(h);
                }
            }
        }

        bw.flush();
        bw.close();
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}