import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0 : 빈 칸
 * 1 : 벽
 * 2 : 바이러스
 *
 * 최대한 바이러스를 안 퍼지게 하는 벽 3개 세우기
 */
public class Main {
    static int N,M;
    static LinkedList<Node> blank = new LinkedList<>(); // 빈 칸인 곳 위치 저장
    static Node[] picked = new Node[3]; // 뽑은 벽 위치 저장
    static int[][] map;
    static int maxSafeAreaCnt;
    public static class Node {
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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j]==0) blank.add(new Node(i, j));
            }
        }

        combination(0, 0);

        System.out.println(maxSafeAreaCnt);

    }

    public static void combination(int start, int cnt){
        if(cnt == 3){
            int[][] copyMap = new int[N][M];

            for(int i = 0; i < N; i++){
                copyMap[i] = map[i].clone();
            }
//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < M; j++){
//                    copyMap[i][j] = map[i][j];
//                }
//            }

            // 뽑은 부분에 벽 세우기
            for(int i = 0; i < picked.length; i++){
                Node wall = picked[i];

                copyMap[wall.x][wall.y] = 1;
            }

            // bfs로 바이러스 퍼뜨리기
            bfs(copyMap);

            return;
        }

        for(int i = start; i < blank.size(); i++){
            picked[cnt] = blank.get(i);
            combination(i + 1, cnt + 1);
        }
    }

    public static void bfs(int[][] map){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[N][M];

        Queue<Node> queue = new LinkedList<>();

        // 바이러스 있는 칸 찾기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 2){
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                }

            }
        }


        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];


                if(nx >=0 && nx < N && ny >=0 && ny < M && map[nx][ny] != 1 && !visited[nx][ny]){
                    queue.add(new Node(nx, ny));
                    if(map[nx][ny] == 0) map[nx][ny] = 2; // 바이러스 전염
                    visited[nx][ny] = true;
                }
            }
        }


        // safeArea 개수 구하기
        int safeAreaCnt = getSafeAreaCnt(map);


        if(safeAreaCnt > maxSafeAreaCnt){
            maxSafeAreaCnt = safeAreaCnt;
        }
    }

    public static int getSafeAreaCnt(int[][] map){
        int safeAreaCnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0) safeAreaCnt++;
            }
        }

        return safeAreaCnt;
    }


}