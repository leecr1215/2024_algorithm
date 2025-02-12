import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int N = 19;
    static int winner = -1;
    static int[][] map = new int[N][N];
    static int resultX, resultY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        for(int j = 0; j < N; j++){
            for(int i = 0; i < N; i++){
                if(map[i][j]!=0){
                    for(int d = 0; d < 4; d++){
                        int step = dfs(i, j, 0, d);

                        if(step == 4){
                            int nx = i - dx[d];
                            int ny = j - dy[d];

                            if(nx >= 0 && ny >= 0 && map[nx][ny] == map[i][j]) continue;

                            System.out.println(map[i][j]);
                            System.out.println((i+1) +" " + (j+1));

                            return;
                        }
                    }


                }

            }

        }

        System.out.println(0);

    }

    // 아래, 오른쪽, 오른쪽 위, 오른쪽 아래
    static int[] dx = {1, 0, -1, 1};
    static int[] dy = {0, 1, 1, 1};
    public static int dfs(int x, int y, int step, int dir){


        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(step < 5 && nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == map[x][y]){
            return dfs(nx, ny, step+1, dir);
        }

        return step;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}