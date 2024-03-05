import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] boxes;
    static int unripeTomatoes = 0; // 안 익은 토마토 개순
    static int finalDate = 0;
    static Queue<Tomato> queue = new LinkedList<>();

    static class Tomato {
        int x;
        int y;
        int date;

        public Tomato(int x, int y, int date){
            this.x = x;
            this.y = y;
            this.date = date;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        boxes = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                int status = Integer.parseInt(st.nextToken());
                boxes[i][j] = status;
                if(status==0) unripeTomatoes++;
                if(status==1) addTomatoes(i, j, 1);
            }
        }


        bfs();

        if(unripeTomatoes != 0){ // 안 익은 토마토가 아직 남아있을 떄
            finalDate = -1;
        }

        System.out.println(finalDate);

    }

    public static void addTomatoes(int x, int y, int date){
        queue.add(new Tomato(x, y, date));
        boxes[x][y] = 3; // 방문 처리
    }

    public static boolean isBoundary(int nx, int ny){
        return nx >=0 && nx < N && ny >= 0 && ny < M && boxes[nx][ny] == 0;
    }

    public static void bfs(){
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                if(isBoundary(nx, ny)){
                    unripeTomatoes--;

                    if(unripeTomatoes == 0){ // 안 익은 토마토가 다 익은 경우
                        finalDate = tomato.date;
                        return;
                    }

                    addTomatoes(nx, ny, tomato.date + 1);
                }
            }


        }

    }
}