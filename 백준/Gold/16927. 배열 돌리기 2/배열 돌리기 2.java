import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] A;
    public static void main(String[] args) throws IOException{
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

        int cnt = Math.min(N, M) / 2;
        for(int s = 1; s <= cnt; s++){
            int rotateCnt = R % (2 * (N - 2 * s + 1)+ 2 * (M - 2 * s + 1));

            for(int r = 0; r < rotateCnt; r++){
                rotate(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                sb.append(A[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());


    }

    // 우, 하, 좌, 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0,-1, 0};

    public static void rotate(int s){
        int x = s;
        int y = s;
        int d = 0;

        int startValue = A[s][s];

        while(d < 4){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= s && nx <= N - s + 1 && ny >= s && ny <= M - s + 1){
                A[x][y] = A[nx][ny];
                x = nx;
                y = ny;
            }else{
                d++;
            }
        }

        A[s+1][s] = startValue;
    }


}