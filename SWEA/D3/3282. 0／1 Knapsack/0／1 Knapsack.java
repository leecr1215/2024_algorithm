import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] volume = new int[N+1];
            int[] value = new int[N+1];

            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());

                volume[i] = Integer.parseInt(st.nextToken());
                value[i] = Integer.parseInt(st.nextToken());
            }

            // 1 ~ N번 물건을 가지고 부피가 K인 가방에 넣을 수 있는 최대 가치
            int[][] dp = new int[N+1][K+1];


            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= K; j++){
                    // 물건의 부피가 남은 가방의 부피보다 크면
                    // 물건 i는 못 넣음
                    if(volume[i] > j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-volume[i]] + value[i]);
                    }
                }
            }

            System.out.println("#"+t+" "+dp[N][K]);
        }
    }
}