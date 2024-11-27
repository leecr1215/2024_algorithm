import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 공간은 4x4
 *
 * 물고기
 * - 번호 : 1 <= 번호 <= 16
 * - 방향 : 8가지 방향
 *
 *
 *
 *
 * 0. 상어 시작
 * (0,0)에서 시작
 * (0,0)에 있던 물고기의 방향으로 시작 (물고기 먹음)
 *
 * 1. 물고기 이동
 * - 번호가 작은 물고기부터 이동
 *
 * - 이동 가능 칸
 *  - 빈 칸
 *  - 다른 물고기 있는 칸
 *         - 서로의 위치를 바꿈!
 * - 이동 X 칸
 *  - 상어 있는 칸
 *  - 공간 밖의 칸
 *
 * - 이동이 가능할 때까지 45도씩 반시계 회전을 하면서 확인함
 *
 * 2. 상어 이동
 * -
 *
 *
 *
 */
public class Main {

    public static class Fish {
        int x;
        int y;
        int dir;

        public Fish(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }


    // 상 상좌 좌 좌하 하 하우 우 우상
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    static final int N = 4;

    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TreeMap<Integer, Fish> fishes = new TreeMap<>();
        Fish shark = new Fish(0,0,0);
        int[][] map = new int[N][N]; // -1이면 상어

        int firstFishNum = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());

                if(i == 0 && j == 0) {
                    shark = new Fish(0, 0, b-1);
                    firstFishNum = a;
                    continue;
                }

                Fish fish = new Fish(i, j, b-1);
                fishes.put(a, fish);
                map[i][j] = a;
            }
        }

        // 0. 상어 초기화
        map[0][0] = -1;

        execute(map, shark, fishes, firstFishNum);

        System.out.println(max);

    }

    public static void execute(int[][] map, Fish shark, TreeMap<Integer, Fish> fishes, int sum){

        // 1. 물고기 이동
        fishMove(map, fishes);

        // 2. 상어 이동
        sharkMove(map, shark, fishes, sum);

        if(sum > max){
            max = sum;
        }
    }

    public static void fishMove(int[][] map, TreeMap<Integer, Fish> fishes){
        Set<Integer> keys = fishes.keySet();
        for(int num : keys){
            Fish fish = fishes.get(num);

            for(int i = 0; i < 8; i++){
                int nx = fish.x + dx[(fish.dir + i) % 8];
                int ny = fish.y + dy[(fish.dir + i) % 8];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] >= 0){

                    if(map[nx][ny] >= 1){
                        // 물고기 있는 칸
                        fishes.get(map[nx][ny]).x = fish.x;
                        fishes.get(map[nx][ny]).y = fish.y;
                        map[fish.x][fish.y] = map[nx][ny];

                    }else if(map[nx][ny] == 0){
                        // 빈 칸
                        map[fish.x][fish.y] = 0;
                    }

                    map[nx][ny] = num;

                    fish.x = nx;
                    fish.y = ny;
                    fish.dir = (fish.dir + i) % 8;

                    break;
                }
            }


        }
    }


    public static void sharkMove(int[][] map, Fish shark, TreeMap<Integer, Fish> fishes, int sum){

        for(int i = 1; i <= 3; i++){
            int nx = shark.x + dx[shark.dir] * i;
            int ny = shark.y + dy[shark.dir] * i;

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > 0){
                // 물고기 잡아먹기
                int[][] mapCopy = copyMap(map);
                TreeMap<Integer, Fish> fishesCopy = copyFishes(fishes);

                int newSum = sum + mapCopy[nx][ny];

                mapCopy[shark.x][shark.y] = 0;
                Fish fish = fishesCopy.get(mapCopy[nx][ny]);

                Fish newShark = new Fish(fish.x, fish.y, fish.dir);

                fishesCopy.remove(mapCopy[nx][ny]);
                mapCopy[nx][ny] = -1;

                execute(mapCopy, newShark, fishesCopy, newSum);
            }

        }

    }

    public static int[][] copyMap(int[][] map){
        int[][] mapCopy = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                mapCopy[i][j] = map[i][j];
            }
        }

        return mapCopy;
    }

    public static TreeMap<Integer, Fish> copyFishes(TreeMap<Integer, Fish> fishes){
        TreeMap<Integer, Fish> fishesCopy = new TreeMap<>();

        for(int key : fishes.keySet()){
            Fish fish = fishes.get(key);
            Fish newFish = new Fish(fish.x, fish.y, fish.dir);
            fishesCopy.put(key, newFish);
        }

        return fishesCopy;

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}