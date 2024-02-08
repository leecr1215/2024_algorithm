import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;
        int cnt; // 현재까지 이동한 칸 수

        public Node(int x, int y, int cnt){
            this.x =  x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[][] maze;
    static boolean[][] visited;
    static int N;
    static int M;
    static int moveCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 0; i < N; i++){
            String str = br.readLine();

            for(int j = 0; j < M; j++){
                maze[i+1][j+1] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(moveCnt);

    }


    static void bfs(){
        // 상 하 좌 우
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,1,1));
        visited[1][1] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && maze[nx][ny] == 1 && !visited[nx][ny]){
                    if(nx == N && ny == M) {
                        moveCnt = node.cnt + 1;
                        return;
                    }
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, node.cnt + 1));
                }
            }
        }
    }
}