
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w,h;
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
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());

            w = stoi(st.nextToken());
            h = stoi(st.nextToken());

            if(w == 0 && h == 0) break;


            visited = new boolean[h][w];
            map = new int[h][w];
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < w; j++){
                    map[i][j] = stoi(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(!visited[i][j] && map[i][j]==1){
                        cnt++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void bfs(int x, int y){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int d = 0; d < 8; d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if(nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 1 && !visited[nx][ny]){
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


