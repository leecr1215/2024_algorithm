import java.io.*;
import java.util.*;

public class 나무_공격 {
    static int[][] map;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = stoi(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int L1 = stoi(st.nextToken());
        int R1 = stoi(st.nextToken());

        attack(L1-1, R1-1);

        st = new StringTokenizer(br.readLine());
        int L2 = stoi(st.nextToken());
        int R2 = stoi(st.nextToken());

        attack(L2-1, R2-1);

        int cnt = findDestroyer();

        System.out.println(cnt);
        
    }

    public static void attack(int start, int end){
        for(int i = start; i <= end; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    break;
                }
            }
        }
    }

    public static int findDestroyer(){
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
