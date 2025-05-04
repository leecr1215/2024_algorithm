import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C,K;
    static char[][] map;
    static int result;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        visited[R-1][0] = true;
        DFS(R-1, 0, 0);

        System.out.println(result);

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void DFS(int x, int y, int len){
        if(len == K-1 && x == 0 && y == C-1){
            result++;
            return;
        }

        if(len >= K-1){
            return;
        }

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.' && !visited[nx][ny]){
                visited[nx][ny] = true;
                DFS(nx, ny, len + 1);
                visited[nx][ny] = false;
            }
        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
