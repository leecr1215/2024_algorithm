import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] originArr = br.readLine().split(" ");

        int[] cumulativeSum = new int[N];
        cumulativeSum[0] = Integer.parseInt(originArr[0]);

        // 누적합 저장
        for(int i = 1; i < N; i++){
            cumulativeSum[i] = cumulativeSum[i-1] + Integer.parseInt(originArr[i]);
        }


        for(int i= 0; i < M; i++){
            String[] ij = br.readLine().split(" ");
            int startIdx = Integer.parseInt(ij[0])-2;
            int endIdx = Integer.parseInt(ij[1])-1;

            int startValue = startIdx < 0 ? 0 : cumulativeSum[startIdx];
            int endValue = cumulativeSum[endIdx];

            int value = endValue - startValue;
            System.out.println(value);
        }

    }
}