import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 0. 기본 정보
 * - 상어는 초기 크기가 2
 *
 * 1. 아기상어 이동
 * - 작은 물고기는 먹고 이동
 * - 같은 물고기는 이동
 * - 큰 물고기는 이동 X
 *
 * - 상하좌우로 이동 (1초 소요)
 * - 자기보다 크기가 작은 물고기가 있으면 이동하고 먹음 -> 빈칸으로 변경
 *      - 가장 가까운 물고기
 *      - 가장 위에 있는 물고기
 *      - 가장 왼쪽에 있는 물고기
*  - 자기보다 크기가 작은 물고기가 없으면 엄마 상어한테 도움 요청
 *
 *  - 상어의 크기와 같은 수의 물고기를 먹으면 크기가 1 커짐
 */
public class Main {
    public static class BabyShark {
        int x;
        int y;
        int size;
        int eats;
        int time;

        public BabyShark(int x, int y){
            this.x = x;
            this.y = y;
            this.size = 2;
            this.eats = 0;
            this.time = 0;
        }
    }

    public static class Fish{
        int x;
        int y;
        int distance;

        public Fish(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int N;
    static int[][] map;
    static BabyShark shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = stoi(st.nextToken());

                if(map[i][j]==9){
                    shark = new BabyShark(i, j);
                    map[i][j] = 0;
                }
            }
        }

        while(true){
            // 1. 먹을 수 있는 물고기 구하기
            Fish fish = canEatFishes();

            if(fish.distance == -1) break; // 먹을 수 있는 물고기가 없음

            // 2. 이동
            map[fish.x][fish.y] = 0; // 먹혀서 빈 칸됨
            shark.x = fish.x;
            shark.y = fish.y;

            // 3. 물고기 먹기
            shark.time += fish.distance;
            shark.eats += 1;
            if(shark.eats == shark.size){
                shark.size += 1;
                shark.eats = 0;
            }
        }

        System.out.println(shark.time);

    }

    // 먹을 수 있는 물고기 리턴
    // 우선순위 : 거리, 상, 좌, 우, 하
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    public static Fish canEatFishes(){
        ArrayList<Fish> fishes = new ArrayList<>();

        Queue<Fish> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new Fish(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;

        while(!queue.isEmpty()){
            Fish fish = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = fish.x + dx[i];
                int ny = fish.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] <= shark.size){
                    if(map[nx][ny] < shark.size && map[nx][ny] > 0){
                        // 나보다 작은 물고기!
                        // 먹을 수 있음
                        fishes.add(new Fish(nx, ny, fish.distance + 1));
                    }else{
                        // 빈 칸이거나 나랑 크기가 같은 물고기
                        // 먹을 수 있는 물고기를 찾아.. 떠나기..
                        queue.add(new Fish(nx, ny, fish.distance + 1));
                        visited[nx][ny] = true;
                    }


                }
            }
        }

        if(fishes.size() == 0){
            return new Fish(-1, -1, -1);
        }

        Collections.sort(fishes, (f1, f2) -> {
            if(f1.distance == f2.distance){
                if(f1.x == f2.x){
                    return f1.y - f2.y;
                }
                return f1.x - f2.x;
            }else{
                return f1.distance - f2.distance;
            }
        });

        return fishes.get(0);
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}