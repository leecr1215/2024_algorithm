import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        int[] value = new int[N+1];
        int[] weight = new int[N+1];

        // 0~i번째까지의 물건을 사용했을 떄 최대 무게 j를 넘지 않는 최대 가치
        int[][] dp = new int[N+1][K+1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            weight[i+1] = stoi(st.nextToken());
            value[i+1] = stoi(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(weight[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], value[i] + dp[i-1][j-weight[i]]);
                }
            }
        }


        System.out.println(dp[N][K]);
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}