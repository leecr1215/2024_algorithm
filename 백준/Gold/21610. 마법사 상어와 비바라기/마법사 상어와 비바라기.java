import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Node> clouds = new ArrayList<>();

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        clouds.add(new Node(N, 1));
        clouds.add(new Node(N, 2));
        clouds.add(new Node(N-1, 1));
        clouds.add(new Node(N-1, 2));

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int d = stoi(st.nextToken())-1;
            int s = stoi(st.nextToken());

            // 1. 모든 구름이 d방향으로 s칸 이동한다
            moveClouds(d, s);

            // 2.각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
            raining();

            // 4. 구름이 현재 있는 칸들에 물복사 마법 시전
            magic();

            // 5. 새로운 구름 생성
            makeClouds();
        }

        int waterSum = getWaterSum();

        System.out.println(waterSum);
    }

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    /**
     *
     * @param d
     * @param s
     *
     *
     * N 이 5
     * 0 => 5(N)
     * -1 => 4(N-1)
     * -2 => 3(N-2)
     * -3 => 2(N-3)
     * -4 => 1 (N-4)
     * -5 => 0 => 5 (N)
     * -6 => -1 => 4(N-1)
     */
    public static void moveClouds(int d, int s){
        for(Node cloud : clouds){
            int nx = cloud.x + dx[d] * s;
            int ny = cloud.y + dy[d] * s;

            if(nx > N) nx = nx % N;
            if(nx < 1) nx = N - (Math.abs(nx) % N);

            if(ny > N) ny = ny % N;
            if(ny < 1) ny = N - (Math.abs(ny) % N);

            cloud.x = nx;
            cloud.y = ny;
        }
    }

    public static void raining(){
        for(Node cloud : clouds){
            map[cloud.x][cloud.y]++;
        }
    }

    // 대각선 : 1, 3, 5, 7
    public static void magic(){
        for(Node cloud : clouds){

            int waterCnt = 0;
            for(int i = 1; i <= 7; i+=2){
                int nx = cloud.x + dx[i];
                int ny = cloud.y + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && map[nx][ny] > 0){
                    waterCnt++;
                }

            }

            map[cloud.x][cloud.y] += waterCnt;
        }
    }

    public static void makeClouds(){
        ArrayList<Node> newClouds = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(map[i][j] >= 2 && !isPrevCloud(i, j)){
                    map[i][j] -= 2;
                    newClouds.add(new Node(i, j));
                }
            }
        }

        clouds = newClouds;
    }

    public static boolean isPrevCloud(int x, int y){
        for(Node cloud : clouds){
            if(cloud.x == x && cloud.y == y){
                return true;
            }
        }

        return false;
    }

    public static int getWaterSum(){
        int sum = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                sum += map[i][j];
            }
        }

        return sum;
    }

    public static void printMap(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}