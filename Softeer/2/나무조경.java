import java.io.*;
import java.util.*;

public class 나무조경 {

    
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int result;
    
    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        int sum = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
                sum += map[i][j];
            }
        }

        if(N == 2){
            System.out.println(sum);
        }else {
            dfs(0,0);
            System.out.println(result);
        }

    }


    // 오른쪽, 아래
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    
    // 나무 쌍 조합 중에 4개 뽑기
    public static void dfs(int cnt, int sum){
        if(cnt == 4){
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j]) continue;
                
                for(int d = 0; d < 2; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(!isAble(nx, ny)) continue;

                    visited[i][j] = true;
                    visited[nx][ny] = true;

                    dfs(cnt + 1, sum + map[i][j] + map[nx][ny]);

                    visited[i][j] = false;
                    visited[nx][ny] = false;
                    
                }
            }
        }
    }

    public static boolean isAble(int nx, int ny){
        return nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny];
    }

    
}
