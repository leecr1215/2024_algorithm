import java.io.*;
import java.util.*;

public class 함께하는_효도 {
    public static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    
    static int n, m;
    static int[][] map;
    static Node[] friends;
    static boolean[][] visited;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        visited = new boolean[n][n];
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        friends = new Node[m];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            friends[i] = new Node(stoi(st.nextToken())-1, stoi(st.nextToken())-1);
        }
        
        dfs(0, 0, 0, friends[0]);
        
        for(Node friend : friends){
            result += map[friend.x][friend.y];
        }

        System.out.println(result);
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void dfs(int fCnt, int cnt, int sum, Node friend){
        if(cnt == 3){
            if(fCnt == m-1){
                // 마지막 친구 완
                result = Math.max(result, sum);
            }else{
                dfs(fCnt + 1, 0, sum, friends[fCnt + 1]);
            }
            return;
        }

        
        visited[friend.x][friend.y] = true;
        
        for(int i = 0; i < 4; i++){
            int nx = friend.x + dx[i];
            int ny = friend.y + dy[i];

            if(!isAble(nx, ny)) continue;

            visited[nx][ny] = true;
            dfs(fCnt, cnt + 1, sum + map[nx][ny], new Node(nx, ny));
            visited[nx][ny] = false;
        }
        
        visited[friend.x][friend.y] = false;
    }

    public static boolean isAble(int nx, int ny){
        return nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny];
    }


    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
