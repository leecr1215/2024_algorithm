import java.io.*;
import java.util.*;

public class 이미지_프로세싱 {
    static int[][] map;
    static int H,W;

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = stoi(st.nextToken());
        W = stoi(st.nextToken());

        map = new int[H+1][W+1];
        for(int i = 1; i <= H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= W; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        int Q = stoi(br.readLine());
        for(int q = 0; q < Q; q++){
            st = new StringTokenizer(br.readLine());

            int i = stoi(st.nextToken());
            int j = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            imageProcessing(i, j, c);
        }

        printMap();
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void imageProcessing(int x, int y, int c){
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[H+1][W+1];

        int targetColor = map[x][y];

        queue.add(new Node(x, y));
        visited[x][y] = true;
        map[x][y] = c;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 1 && nx <= H && ny >= 1 && ny <= W && !visited[nx][ny] && map[nx][ny] == targetColor){
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = c;
                }
            }


        }

    }

    public static void printMap(){
        for(int i = 1; i <= H; i++){
            for(int j = 1; j <= W; j++){
                System.out.print(map[i][j] + " ");
            }
            if(i!=H) System.out.println();
        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
