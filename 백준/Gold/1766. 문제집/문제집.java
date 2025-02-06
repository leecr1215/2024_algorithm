import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new LinkedList<>());
        }
        
        // 각 번호의 진입차수 저장
        int[] inDegree = new int[N+1];


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());

            graph.get(A).add(B);
            inDegree[B]++;
        }

        topologicalSort(inDegree, graph);

    }

    public static void topologicalSort(int[] inDegree, LinkedList<LinkedList<Integer>> graph) throws IOException{
        // 문제 번호가 작은 게 우선순위 높음
        Queue<Integer> queue = new PriorityQueue<>();

        // 진입차수 0인 것 queue에 넣기
        for(int i = 1; i <= N; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(!queue.isEmpty()){
            int problem = queue.poll();
            bw.write(problem + " ");

            // 해당 문제와 연결된 문제들과의 간선 제거
            for(int p : graph.get(problem)){
                inDegree[p]--;

                // 진입차수 0이면 큐에 추가
                // 나중에 for문 끝나고 다시 큐에서 뽑을 때는 자동으로 문제번호가 작은게 앞에 오게 될 것!
                if(inDegree[p] == 0){
                    queue.add(p);
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