import java.io.*;
import java.util.*;

public class Main {

    public static class Node{
        int point; // 위치
        int time; // 걸린 시간

        public Node(int point, int time){
            this.point = point;
            this.time = time;
        }

    }

    static int N,K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        bfs();
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[100_001];

        queue.add(new Node(N, 0));
        visited[N] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.point == K){
                System.out.println(node.time);
                break;
            }

            // x - 1
            if(node.point - 1 >= 0 && !visited[node.point - 1]){
                queue.add(new Node(node.point - 1, node.time + 1));
                visited[node.point-1] = true;
            }

            // x + 1
            if(node.point + 1 <= 100_000 && !visited[node.point + 1]){
                queue.add(new Node(node.point + 1, node.time + 1));
                visited[node.point+1] = true;
            }

            // x * 2
            if(node.point * 2 <= 100_000 && !visited[node.point * 2]){
                queue.add(new Node(node.point * 2, node.time + 1));
                visited[node.point*2] = true;
            }

        }

    }

}