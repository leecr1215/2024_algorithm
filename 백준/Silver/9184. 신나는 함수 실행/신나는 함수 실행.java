import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 음수는 조건에서 걸림 최대 20까지
    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while(true){
            st = new StringTokenizer(br.readLine());

            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            if(a == -1 && b == -1 && c == -1){
                break;
            }

            int result = dynamic(a, b, c);
            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, result);

        }

    }

    public static int dynamic(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        }

        if(a > 20 || b > 20 || c > 20){
            return dynamic(20, 20, 20);
        }

        // 이미 dp에 값이 구해져 있는 경우
        if(dp[a][b][c] > 0){
            return dp[a][b][c];
        }

        if(a < b && b < c){
            dp[a][b][c] = dynamic(a, b, c-1) + dynamic(a, b-1, c-1) - dynamic(a, b-1, c);
        }else{
            dp[a][b][c] = dynamic(a-1, b, c) + dynamic(a-1, b-1, c) + dynamic(a-1, b, c-1) - dynamic(a-1, b-1, c-1);
        }

        return dp[a][b][c];



    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}