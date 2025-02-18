import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] box;
    static int M,N,H;

    public static class Node{
        int z;
        int x;
        int y;
        int day;

        public Node(int z, int x, int y, int day){
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());
        H = stoi(st.nextToken());

        box = new int[H][N][M];

        Queue<Node> queue = new ArrayDeque<>();

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    box[i][j][k] = stoi(st.nextToken());

                    if(box[i][j][k] == 1){
                        queue.add(new Node(i, j, k, 0));
                    }
                }
            }
        }

        if(allTomatoRiped()){
            System.out.println(0);
            return;
        }

        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dy = {0, 0, 0, 0, -1, 1};
        int[] dz = {-1, 1, 0, 0, 0, 0};

        int minDay = 100*100*100;
        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0; i < 6; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H  && box[nz][nx][ny]==0){
                    queue.add(new Node(nz, nx, ny, node.day + 1));
                    box[nz][nx][ny] = 1;
                }
            }

            if(allTomatoRiped()){
                minDay = node.day + 1;
                break;
            }

        }

        if(minDay == 100*100*100){
            System.out.println(-1);
        }else{
            System.out.println(minDay);
        }


    }

    public static boolean allTomatoRiped(){
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(box[i][j][k] == 0){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}