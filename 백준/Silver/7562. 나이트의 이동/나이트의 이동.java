import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for(int t = 0; t < T; t++){
            int I = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            Node startNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            st = new StringTokenizer(br.readLine());
            Node targetNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            int cnt = bfs(I, startNode, targetNode);

            System.out.println(cnt);
        }

    }

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static int bfs(int N, Node startNode, Node targetNode){
        boolean[][] visited = new boolean[N][N];
        Queue<Node> queue = new ArrayDeque<>();
        visited[startNode.x][startNode.y] = true;
        queue.add(startNode);

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 8; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                    if(targetNode.x == nx && targetNode.y == ny){
                        return node.cnt + 1;
                    }
                    queue.add(new Node(nx, ny, node.cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return 0;
    }
}