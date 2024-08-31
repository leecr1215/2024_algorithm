import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static char[][] map;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        int cnt1 = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    // 적록색약이 아닌 사람이 봤을 때
                    bfs(i, j);
                    cnt1++;
                }
                // 이미 방문한 정점이니까
                // G를 모두 R로 변경해주기
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }

        int cnt2 = 0;
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    // 적록색약이 아닌 사람이 봤을 때
                    bfs(i, j);
                    cnt2++;
                }

            }
        }

        System.out.println(cnt1 + " " + cnt2);

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        char target = map[x][y];

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == target){
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}