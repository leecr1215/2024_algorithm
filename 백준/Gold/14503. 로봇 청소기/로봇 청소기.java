import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 벽 : 1, 청소 X : 0, 청소 O : 2
public class Main {
    // 북동남서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;
    static int N, M, r, c, d;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleaning();

        System.out.println(cnt);


    }

    public static void cleaning(){
        // 1. 현재 칸이 청소되지 않은 경우
        if(map[r][c]==0){
            map[r][c] = 2;
            cnt++;
        }

        boolean hasDirtyRoom = false;
        for(int i = 0; i < 4; i++){
            // 반시계 방향으로 회전
            rotate();

            // 앞쪽 칸이 청소되지 않은 빈칸
            int nr = r + dx[d];
            int nc = c + dy[d];

            if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0){
                // 한 칸 전진
                r = nr;
                c = nc;
                hasDirtyRoom = true;
                cleaning();
            }
        }

        if(!hasDirtyRoom){
            int backR = r + dx[(d + 2) % 4];
            int backC = c + dy[(d + 2) % 4];

            if(backR >= 0 && backR < N && backC >= 0 && backC < M && map[backR][backC] == 1){
                // 벽이면 그만!
                return;
            }else{
                // 한 칸 후진
                r = backR;
                c = backC;

                cleaning();
            }
        }
    }

    // 반시계 방향으로 90도 회전
    public static void rotate(){
        d = (d + 3) % 4;
    }


}