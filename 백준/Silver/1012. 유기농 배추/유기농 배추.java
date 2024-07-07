import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int M, N;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 개수

            map = new int[M][N];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = -1;
            }

            int cnt = 0;

            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == -1){
                        bfs(++cnt, i, j);
                    }
                }
            }

            System.out.println(cnt);
        }


    }

    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    public static void bfs(int cnt, int x, int y){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x, y));
        map[x][y] = cnt;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int d = 0; d < 4; d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N &&  map[nx][ny]==-1){
                    queue.add(new Node(nx, ny));
                    map[nx][ny] = cnt;
                }
            }

        }
    }
}