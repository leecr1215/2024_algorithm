import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        map = new int[N][N];

        int min = 100;
        int max = 0;

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = stoi(st.nextToken());

                if(map[i][j] < min){
                    min = map[i][j];
                }else if(map[i][j] > max){
                    max = map[i][j];
                }
            }
        }


        if(min > 0) {
            min = min - 1;
        }

        int maxCnt = 0;

        for(int t = min; t < max; t++){
            int cnt = 0;
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && map[i][j] > t){
                        bfs(i, j, t);
                        cnt++;
                    }
                }
            }


            if(cnt > maxCnt){
                maxCnt = cnt;
            }
        }


        System.out.println(maxCnt);

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // height 이하인 높이는 물에 잠김
    public static void bfs(int x, int y, int height){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;


        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] > height){
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }

        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}