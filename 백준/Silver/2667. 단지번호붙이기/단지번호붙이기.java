import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] map;
    private static LinkedList<Integer> homeCnts = new LinkedList<>();

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
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();

            for(int j = 0; j < N; j++){
                int value = str.charAt(j) - '0';
                if(value==0) map[i][j] = value;
                else map[i][j] = -1;
            }
        }

        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j]==-1) bfs(++cnt, i, j);
            }
        }

        System.out.println(cnt);

        Collections.sort(homeCnts);

        for(int homeCnt : homeCnts){
            System.out.println(homeCnt);
        }


    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void bfs(int cnt, int x, int y){
        int homeCnt = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        map[x][y] = cnt;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == -1){
                    queue.add(new Node(nx, ny));
                    map[nx][ny] = cnt;
                    homeCnt++;
                }
            }

        }

        homeCnts.add(homeCnt);

    }
}