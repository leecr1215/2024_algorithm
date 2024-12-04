import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;

    public static class Node{
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        map = new int[n][m];

        int targetX = -1;
        int targetY = -1;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = stoi(st.nextToken());

                if(map[i][j]==2){
                    targetX = i;
                    targetY = j;
                }
            }
        }

        int[][] result = bfs(targetX, targetY);

        print(result);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static int[][] bfs(int x, int y){
        Queue<Node> queue = new ArrayDeque<>();

        int[][] result = new int[n][m];
        for(int[] row : result){
            Arrays.fill(row, -1);
        }

        queue.add(new Node(x, y, 0));
        result[x][y] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && result[nx][ny] == -1){
                    if(map[nx][ny] == 0){
                        result[nx][ny] = 0;
                    }else{
                        queue.add(new Node(nx, ny, node.distance+1));
                        result[nx][ny] = node.distance + 1;
                    }

                }

            }

        }

        return result;

    }

    public static void print(int[][] arr){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(map[i][j] == 0 ? 0 + " " : arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}