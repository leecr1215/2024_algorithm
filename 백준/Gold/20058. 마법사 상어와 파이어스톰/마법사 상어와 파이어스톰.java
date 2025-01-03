import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static int[][] map;
    static int[] Ln;

    public static class Ice{
        int x;
        int y;

        public Ice(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = (int) Math.pow(2, stoi(st.nextToken()));
        Q = stoi(st.nextToken());


        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        Ln = new int[Q];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++){
            Ln[i] = stoi(st.nextToken());
        }

        for(int i = 0; i < Q; i++){
            fireStorm(Ln[i]);
        }

        // 3. 남은 얼음의 합 구하기
        int sum = getIceSum();
        System.out.println(sum);

        // 4. 남아있는 얼음 중 가능 큰 덩어리가 차지하는 칸의 개수
        int maxCnt = getMaxMassCnt();
        System.out.println(maxCnt);
    }

    public static void fireStorm(int L) {
        // 1. 부분 격자를 시계 방향으로 90도 회전
        map = rotate(L);

        // 2. 얼음이 0인 칸과 인접한 칸들을 얼음 양 1 줄이기
        reduceIce();
    }

    public static int[][] rotate(int L){
        int[][] newMap = new int[N][N];

        int len = (int) Math.pow(2, L);

        for(int i = 0; i < N; i+=len){
            for(int j = 0; j < N; j+=len){

                for(int k = 0; k < len; k++){
                    for(int l = 0; l < len; l++){
                        newMap[i+k][j+l] = map[len - l - 1 + i][k + j];
                    }
                }
            }
        }


        return newMap;
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void reduceIce(){
        ArrayList<Ice> ices = new ArrayList<>(); // 얼음 줄일 칸 저장

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                int cnt = 0; // 주변에 얼음 있는 칸 개수

                for(int d = 0; d < 4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > 0){
                        cnt++;
                    }
                }

                if(cnt < 3){
                    ices.add(new Ice(i, j));
                }
            }
        }

        // 얼음 줄이기
        for(Ice ice : ices){
            if(map[ice.x][ice.y] > 0){
                map[ice.x][ice.y]--;
            }
        }
    }

    public static int getIceSum(){
        int sum = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sum += map[i][j];
            }
        }

        return sum;
    }

    static boolean[][] visited;
    public static int getMaxMassCnt(){
        int maxCnt = 0;

        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] > 0){
                    int cnt = bfs(i, j);

                    if(cnt > maxCnt){
                        maxCnt = cnt;
                    }
                }
            }
        }

        return maxCnt;
    }

    public static int bfs(int x, int y){
        Queue<Ice> queue = new ArrayDeque<>();
        queue.add(new Ice(x, y));
        visited[x][y] = true;
        int cnt = 1;

        while(!queue.isEmpty()){
            Ice ice = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > 0 && !visited[nx][ny]){
                    queue.add(new Ice(nx, ny));
                    visited[nx][ny] = true;
                    cnt++;
                }
            }

        }

        return cnt;
    }

    public static void print(){
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