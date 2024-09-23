import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int cnt, N, M;
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];


        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            for(int x = x1; x < x2; x++){
                for(int y = y1; y < y2; y++){
                    map[x][y] = 1;
                }
            }

        }

//        printMap();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        Collections.sort(list);

        for(int width : list){
            System.out.print(width + " ");
        }

    }

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(int x, int y){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;
        int width = 1;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && !visited[nx][ny]){
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    width++;
                }
            }
        }

        list.add(width);

    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void printMap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}