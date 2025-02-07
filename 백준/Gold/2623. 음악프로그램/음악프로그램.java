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
            String[] strs = br.readLine().split(" ");

            for(int j = 1; j < strs.length-1; j++){
                graph.get(stoi(strs[j])).add(stoi(strs[j+1]));
                inDegree[stoi(strs[j+1])]++;
            }
        }

        topologicalSort(N, inDegree, graph);

    }

    public static void topologicalSort(int N, int[] inDegree, LinkedList<LinkedList<Integer>> graph) throws IOException{
        Queue<Integer> queue = new ArrayDeque<>();

        // 1. 큐에 inDegree 0인 애들 먼저 넣기
        for(int i = 1; i <= N; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        int cnt = 0; // 출력한 문제 수

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!queue.isEmpty()){
            int singer = queue.poll();
            bw.write(singer + "\n");
            cnt++;

            // 2. singer의 후순위인 번호의 inDegree삭제
            for(int number : graph.get(singer)){
                inDegree[number]--;

                if(inDegree[number] == 0){
                    queue.add(number);
                }
            }
        }

        if(cnt != N){
            System.out.println(0);
        }else{
            bw.flush();
        }

        bw.close();

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}