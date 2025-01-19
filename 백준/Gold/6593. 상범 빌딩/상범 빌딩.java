import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;
        int z;
        int time;

        public Node(int x, int y, int z, int time){
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());

            int L = stoi(st.nextToken()); // 층 수
            int R = stoi(st.nextToken()); // 행 수
            int C = stoi(st.nextToken()); // 열 수

            if(L == 0 && R == 0 && C == 0) break;

            Node start = new Node(-1, -1, -1, 0);

            char[][][] building = new char[L][R][C];
            String line = "";

            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    line = br.readLine();
                    for(int k = 0; k < C; k++){
                        building[i][j][k] = line.charAt(k);

                        if(building[i][j][k] == 'S'){
                            start.x = j;
                            start.y = k;
                            start.z = i;
                        }
                    }
                }
                line = br.readLine();
            }

            int time = bfs(L, R, C, start, building);

            if(time == -1){
                fail();
            }else{
                success(time);
            }

        }

    }

    // 동 서 남 북 상 하
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    public static int bfs(int L, int R, int C, Node start, char[][][] building){
        boolean[][][] visited = new boolean[L][R][C];
        Queue<Node> queue = new ArrayDeque<>();


        visited[start.z][start.x][start.y] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 6; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];

                if(nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L && !visited[nz][nx][ny] && building[nz][nx][ny] != '#'){
                    if(building[nz][nx][ny] == 'E') return node.time + 1;

                    queue.add(new Node(nx, ny, nz, node.time + 1));
                    visited[nz][nx][ny] = true;
                }

            }
        }



        return -1;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void success(int result){
        System.out.println("Escaped in " + result + " minute(s).");
    }

    public static void fail(){
        System.out.println("Trapped!");
    }
}