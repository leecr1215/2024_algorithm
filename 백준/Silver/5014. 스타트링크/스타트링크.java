import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F,S,G,U,D;
    static int buttonCnt;
    static boolean[] visited;

    static class Floor {
        int x; // x좌표
        int cnt; // 현재까지 몇 번 눌렸는지

        public Floor(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 건물의 총 높이
        S = Integer.parseInt(st.nextToken())-1; // 강호가 지금 있는 곳
        G = Integer.parseInt(st.nextToken())-1; // 스타트링크가 있는 곳의 위치(목적지)
        U = Integer.parseInt(st.nextToken()); // 위로 가는 버튼
        D = Integer.parseInt(st.nextToken()); // 아래로 가는 버튼

        visited = new boolean[F];

        bfs();

        System.out.println(visited[G] ? buttonCnt : "use the stairs");
    }

    static void bfs() {
        int[] dx = {-D, U};

        Queue<Floor> queue = new LinkedList<>();
        queue.add(new Floor(S, 0));
        visited[S] = true;

        while(!queue.isEmpty()){
            Floor floor = queue.poll();

            for(int i = 0; i < 2; i++){
                int nx = floor.x + dx[i];

                if(nx >= 0 && nx < F && !visited[nx]){
                    queue.add(new Floor(nx, floor.cnt+1));
                    visited[nx] = true;
                    if(nx == G){
                        buttonCnt = floor.cnt+1;
                        break;
                    };
                }
            }

        }
    }

}