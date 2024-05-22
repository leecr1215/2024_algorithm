import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int vertex; // 현재 정점 번호
        int dist; // 현재 정점까지의 거리
        
        public Node(int vertex, int dist){
            this.vertex = vertex;
            this.dist = dist;
        }
    }
    
    public static void main(String[] args) throws IOException {
        final int INF = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 수
        int E = Integer.parseInt(st.nextToken()); // 간선 수
        
        int K = Integer.parseInt(br.readLine()); // 시작 정점 번호

        // 인접 리스트로 각 정점사이의 관계 저장
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < V+1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            
            // u -> v로 가는 가중치 w인 간선
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }


        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2)->node1.dist - node2.dist);

        // 시작 정점으로부터 최단 거리를 저장하는 배열
        // 최단 거리 무한대로 초기화
        int[] d = new int[V+1];
        Arrays.fill(d, INF);

        // 처음 시작 정점의 최단 거리는 0
        // pq에도 넣어주기
        d[K] = 0;
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();

            // 최단 거리 테이블에 있는 값이랑 node의 거리가 같으면
            // 현재의 node가 최단 거리를 거쳐온 node라는 의미
            // 따라서 지금 뽑은 node에서 이어져있는 애들의 최단 거리를 갱신 시도(이미 최단 거리 저장되어 있을 수도 있음)

            // 거리가 다르다는 건 뽑힌 노드가 최단거리로 거쳐온 노드가 아니라는 얘기임
            if(curNode.dist == d[curNode.vertex]){
                for(int i = 0; i < graph.get(curNode.vertex).size(); i++){
                    Node newNode = graph.get(curNode.vertex).get(i);

                    if(curNode.dist + newNode.dist < d[newNode.vertex]){
                        d[newNode.vertex] = curNode.dist + newNode.dist;
                        pq.add(new Node(newNode.vertex, d[newNode.vertex]));
                    }

                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= V; i++){
            if(d[i] == INF){
                sb.append("INF").append("\n");
            }else{
                sb.append(d[i]).append("\n");
            }
        }

        System.out.println(sb.toString());


    }
}