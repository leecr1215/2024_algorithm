import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int N = str1.length();
        int M = str2.length();

        int[][] dp = new int[N+1][M+1];


        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = N;
        int j = M;

        while(true){
            if(dp[i][j] == 0) break;

            if(dp[i][j] == dp[i-1][j]){
                i = i-1;
            }else if(dp[i][j] == dp[i][j-1]){
                j = j-1;
            }else{
                sb.append(str1.charAt(i-1));
                i = i-1;
                j = j-1;
            }
        }

        System.out.println(dp[N][M]);
        if(sb.length() > 0) System.out.println(sb.reverse());

    }
}