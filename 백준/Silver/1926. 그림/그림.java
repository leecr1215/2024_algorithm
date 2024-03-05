import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Picture{
        int x;
        int y;

        public Picture(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N,M;
    static int[][] paper;
    static int maxPictureCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(paper[i][j] == 1){
                    bfs(i, j);
                    num++;
                }
            }
        }

        System.out.println(num);
        System.out.println(maxPictureCnt);
    }

    static void bfs(int startX, int startY){
        Queue<Picture> queue = new LinkedList<>();
        queue.add(new Picture(startX, startY));
        paper[startX][startY] = -1;

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        int cnt = 0; // 현재 그림의 개수 저장
        while(!queue.isEmpty()){
            Picture picture = queue.poll();
            cnt++;
            
            for(int i = 0; i < 4; i++){
                int nx = picture.x + dx[i];
                int ny = picture.y + dy[i];

                if(isBoundary(nx, ny) && isPicture(nx,ny)){
                    // 큐에 넣기
                    queue.add(new Picture(nx, ny));

                    // 방문 처리
                    paper[nx][ny] = -1;

                }
            }


        }

        if(maxPictureCnt < cnt){
            maxPictureCnt = cnt;
        }

    }

    static boolean isBoundary(int nx, int ny){
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    static boolean isPicture(int nx, int ny){
        return paper[nx][ny] == 1;
    }
}