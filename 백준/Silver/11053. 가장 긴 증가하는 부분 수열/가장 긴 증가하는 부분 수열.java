import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");


        // i번째 인덱스까지의 가장 긴 증가하는 부분 수열의 길이
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        int max = 0;

        for(int i = 0; i < arr.length; i++){
            int sequence = Integer.parseInt(arr[i]);
            
            for(int j = 0; j < i; j++){
                if(sequence > Integer.parseInt(arr[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}