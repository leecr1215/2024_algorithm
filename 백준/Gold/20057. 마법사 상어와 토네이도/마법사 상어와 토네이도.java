import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 왼 1칸
 * 아래 1칸
 *
 * 오른 2칸
 * 위 2칸
 *
 * 왼 3칸
 * 아래 3칸
 *
 * 오른 4칸
 * 위 4칸
 *
 * 왼 5칸
 * 아래 5칸
 *
 * 오른 6칸
 * 위 6칸
 * 왼 6칸
 *
 *
 */

public class Main {
    static int N;
    static int[][] map;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        process();

        System.out.println(sum);

    }

    // 왼 아래 오른쪽 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void process(){
        int x = N / 2;
        int y = N / 2;

        int d = 0;
        int cnt = 1; // 움질일 칸 수. N-1 칸을 이동해야 하는 때는 3번 방향 바꿔서!


        while(true){

            for(int c = 1; c <= cnt; c++){
                x = x + dx[d];
                y = y + dy[d];

                spread(d, x, y);

            }

            d++;
            if(d > 3) d = 0;

            for(int c = 1; c <= cnt; c++){
                x = x + dx[d];
                y = y + dy[d];

                spread(d, x, y);
            }

            d++;
            if(d > 3) d = 0;

            if(cnt == N-1){
                for(int c = 1; c <= cnt; c++){
                    x = x + dx[d];
                    y = y + dy[d];

                    spread(d, x, y);
                }

                break;
            }

            cnt++;

        }




    }

    static double[] percent = {0.01, 0.01, 0.02, 0.02, 0.07, 0.07, 0.05, 0.10, 0.10};

    // 왼
    static int[] dx0 = {-1, 1, -2, 2, -1, 1, 0, -1, 1};
    static int[] dy0 = {1, 1, 0, 0, 0, 0, -2, -1, -1};

    // 아래
    static int[] dx1 = {-1, -1, 0, 0, 0, 0, 2, 1, 1};
    static int[] dy1 = {-1, 1, -2, 2, -1, 1, 0, -1, 1};

    // 오른쪽
    static int[] dx2 = {-1, 1, -2, 2, -1, 1, 0, -1, 1};
    static int[] dy2 = {-1, -1, 0, 0, 0, 0, 2, 1, 1};

    // 위
    static int[] dx3 = {1, 1, 0, 0, 0, 0, -2, -1, -1};
    static int[] dy3 = {-1, 1, -2, 2, -1, 1, 0, -1, 1};

    // 여기서 x와 y는 이미 이동한 후의 위치임
    public static void spread(int d, int x, int y){
        int sand = map[x][y];
        map[x][y] = 0;

        int plusSandSum = 0;

        int nx = x;
        int ny = y;

        for(int i = 0; i < 9; i++){
            if(d == 0){
                nx = x + dx0[i];
                ny = y + dy0[i];
            }else if(d == 1){
                nx = x + dx1[i];
                ny = y + dy1[i];
            }else if(d == 2){
                nx = x + dx2[i];
                ny = y + dy2[i];
            }else{
                nx = x + dx3[i];
                ny = y + dy3[i];
            }

            int plusSand = (int)Math.floor(sand * percent[i]);
            plusSandSum += plusSand;


            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                // 범위내
                map[nx][ny] += plusSand;
            }else{
                // 범위 밖
                sum += plusSand;
            }
        }

        // 알파에다가 넣어주기
        int rest = sand - plusSandSum;

        if(d == 0){ // 왼
            nx = x;
            ny = y - 1;
        }else if(d == 1){ // 아래
            nx = x + 1;
            ny = y;
        }else if(d == 2){ // 오른
            nx = x;
            ny = y + 1;
        }else { // 위
            nx = x - 1;
            ny = y;
        }

        if(nx >= 0 && nx < N && ny >= 0 && ny < N){
            // 알파가 범위 내
            map[nx][ny] += rest;
        }else{
            // 알파가 범위 바깥
            sum += rest;
        }

    }

    public static void printMap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}