
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int MAX_CNT = 100_001;

        int n = stoi(st.nextToken());
        int k = stoi(st.nextToken());

        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = stoi(br.readLine());
        }

        // j원을 만들 수 있는 최소 동전의 개수
        int[] dp = new int[k+1];

        for(int i = 0; i <= k; i++){
            dp[i] = MAX_CNT;
        }

        dp[0] = 0;

        for(int i = 0; i < n; i++){
            for(int j = coins[i]; j <= k; j++){
                dp[j] = Math.min(dp[j-coins[i]] + 1, dp[j]);
            }
        }

        System.out.println(dp[k] == MAX_CNT ? -1 : dp[k]);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
