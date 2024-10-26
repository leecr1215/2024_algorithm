import java.io.*;
import java.util.*;

public class 장애물_인식_프로그램 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    int blockCnt = bfs(i, j);
                    cnt++;
                    list.add(blockCnt);
                }
            }
        }

        Collections.sort(list);

        System.out.println(cnt);
        for(int blockCnt : list){
            System.out.println(blockCnt);
        }
        
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static int bfs(int x, int y){
        int cnt = 1;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1){
                    cnt++;
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

}
