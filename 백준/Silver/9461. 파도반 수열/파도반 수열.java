import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for(int i = 6; i <= 100; i++){
            dp[i] = dp[i-1] + dp[i-5];
        }


        for(int t = 0; t < T; t++){
            int N = sc.nextInt();

            System.out.println(dp[N]);
        }
    }
}
