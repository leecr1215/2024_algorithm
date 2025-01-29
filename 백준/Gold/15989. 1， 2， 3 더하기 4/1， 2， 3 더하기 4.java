import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());
        // j로 수식이 끝나고, i를 만들 수 있는 경우의 수 (오름차순)
        int[][] dp = new int[10_001][4];

        dp[1][1] = 1; // 1
        dp[2][1] = 1; // 1+1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 1+1+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3


        for(int i = 4; i <= 10000; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int t = 0; t < T; t++){
            int n = stoi(br.readLine());
            bw.write(dp[n][1] + dp[n][2] + dp[n][3] + "\n");

        }

        bw.flush();
        bw.close();


    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}