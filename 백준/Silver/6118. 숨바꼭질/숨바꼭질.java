import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] distances;
    static ArrayList<ArrayList<Integer>> graph;
    static int N, M;

    public static class Node{
        int vertex;
        int distance;

        public Node(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        distances = new int[N+1]; // 1번으로부터의 거리 저장
        Arrays.fill(distances, -1);


        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());

            graph.get(A).add(B);
            graph.get(B).add(A);

        }

        getDistance(1);

        int maxDistance = 0;
        int maxVertex = 1;
        int cnt = 0;

        for(int i = 2; i <= N; i++){
            if(distances[i] > maxDistance){
                maxDistance = distances[i];
                maxVertex =  i;
                cnt = 1;
            }
            else if(distances[i] == maxDistance){
                cnt++;
            }
        }

        System.out.println(maxVertex + " " + distances[maxVertex] + " " + cnt);

    }

    public static void getDistance(int startNode){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(startNode, 0));
        distances[startNode] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            ArrayList<Integer> list = graph.get(node.vertex);

            for(int v : list){
                if(distances[v] == -1){
                    distances[v] = node.distance + 1;
                    queue.add(new Node(v, node.distance + 1));
                }
            }
        }

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}