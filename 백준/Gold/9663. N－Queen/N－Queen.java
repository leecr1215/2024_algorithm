import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int cnt;
    static int[] picked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        picked = new int[N];


        dfs(0);

        System.out.println(cnt);
    }

    public static void dfs(int row){
        if(row == N){
            cnt++;
            return;
        }

        for(int col = 0; col < N; col++){
            picked[row] = col;

            if(isAvailable(row)){
                dfs(row + 1);
            }
        }


    }

    public static boolean isAvailable(int row){
        for(int i = 0; i < row; i++){
            // 같은 열에 존재하거나 대각선에 퀸이 있으면 false
            if(picked[i] == picked[row] || (row-i) == Math.abs(picked[i]-picked[row])){
                return false;
            }
        }

        return true;
    }
}