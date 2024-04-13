import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        A = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < R; r++){
            rotate();
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    // 우, 하, 좌, 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void rotate(){
        // 링 개수
        int cnt = Math.min(N, M) / 2;

        for(int s = 1; s <= cnt; s++){
            int temp = A[s][s];
            int d = 0;

            // 현재 x와 y
            int x = s;
            int y = x;

            while(d < 4){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx >= s && ny >= s && nx <= N - s + 1 && ny <= M - s + 1){
                    // 이동
                    A[x][y] = A[nx][ny];
                    x = nx;
                    y = ny;
                }else{
                    d++;
                }
            }

            // temp에 저장했던 값 옮기기
            A[s+1][s] = temp;
        }
    }
}