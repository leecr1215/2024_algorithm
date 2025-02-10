import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] inDegree;
    static int[] time;
    static LinkedList<LinkedList<Integer>> graph = new LinkedList<>();

    public static class Node{
        int num;
        int time;

        public Node(int num, int time){
            this.num = num;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        inDegree = new int[N+1];
        time = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph.add(new LinkedList<>());
        }

        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            time[i] = stoi(st.nextToken());

            int M = stoi(st.nextToken());

            for(int j = 0; j < M; j++){
                int num = stoi(st.nextToken());

                graph.get(num).add(i);
                inDegree[i]++;
            }
        }

        topologicalSort();


    }

    public static void topologicalSort(){
        Queue<Node> queue = new PriorityQueue<>((a, b)-> a.time - b.time);

        // 1. inDegree 0인 값 넣기
        for(int i = 1; i <= N; i++){
            if(inDegree[i]==0){
                queue.add(new Node(i, time[i]));
            }
        }

        int max = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            max = Math.max(max, node.time);


            for(int n : graph.get(node.num)){
                inDegree[n]--;

                if(inDegree[n] == 0){
                    queue.add(new Node(n, node.time+time[n]));
                }
            }
        }

        System.out.println(max);


    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}