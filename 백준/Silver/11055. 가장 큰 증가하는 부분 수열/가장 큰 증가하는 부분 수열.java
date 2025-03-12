import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            A[i] = stoi(st.nextToken());
            dp[i] = A[i];
        }


        int max = 0;

        for(int i = 0; i < N; i++){

            for(int j = 0; j < i; j++){
                if(A[i] > A[j]){
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
