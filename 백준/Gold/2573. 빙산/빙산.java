
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] iceberg;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
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

        iceberg = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                iceberg[i][j] = stoi(st.nextToken());
            }
        }

        int year = 0;
        boolean[][] isIce;
        int result = 0;


        while(true){
            if(allIceMelt() || result != 0) break;

            year++;

            isIce = new boolean[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(iceberg[i][j] != 0){
                        isIce[i][j] = true;
                    }
                }
            }

            // 녹이기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(iceberg[i][j] != 0){
                        int cnt = 0;
                        for(int d = 0; d < 4; d++){
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if(nx >= 0 && nx < N && ny >= 0 && ny < M && iceberg[nx][ny] == 0 && !isIce[nx][ny]){
                                cnt++;
                            }
                        }

                        iceberg[i][j] = Math.max(iceberg[i][j] - cnt, 0);
                    }
                }
            }

            // 빙산 덩어리 확인
            int cnt = 0;
            visited = new boolean[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(iceberg[i][j] != 0 && !visited[i][j]){
                        bfs(i, j);
                        cnt++;

                        if(cnt >= 2){
                            result = year;
                            break;
                        }
                    }
                }

                if(result != 0) break;
            }

        }

        System.out.println(result);
    }

    public static void bfs(int x, int y){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int d = 0; d < 4; d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && iceberg[nx][ny] != 0){
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

    }

    public static boolean allIceMelt(){
        boolean isAllIceMelt = true;

        for(int i = 0; i < N; i++){

            for(int j = 0; j < M; j++){
                if(iceberg[i][j] != 0) {
                    isAllIceMelt = false;
                    break;
                }
            }

            if(!isAllIceMelt) break;
        }

        return isAllIceMelt;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
