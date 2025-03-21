import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[][] counts = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                counts[i][j] = stoi(st.nextToken());
            }
        }

        int[][] cumulativeSum = new int[N][M];
        cumulativeSum[0][0] = counts[0][0];

        // 0번째 행과 열 채우기
        for(int i = 1; i < M; i++){
            cumulativeSum[0][i] = cumulativeSum[0][i-1] + counts[0][i];
        }

        for(int i = 1; i < N; i++){
            cumulativeSum[i][0] = cumulativeSum[i-1][0] + counts[i][0];
        }

        // 나머지 부분 채우기
        for(int i = 1; i < N; i++){
            for(int j = 1; j < M; j++){
                cumulativeSum[i][j] = cumulativeSum[i][j-1] + cumulativeSum[i-1][j] + counts[i][j] - cumulativeSum[i-1][j-1];
            }
        }

        int K = stoi(br.readLine());
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = stoi(st.nextToken()) - 1;
            int y1 = stoi(st.nextToken()) - 1;
            int x2 = stoi(st.nextToken()) - 1;
            int y2 = stoi(st.nextToken()) - 1;

            int answer = cumulativeSum[x2][y2];

            if (x1 > 0) answer -= cumulativeSum[x1 - 1][y2];
            if (y1 > 0) answer -= cumulativeSum[x2][y1 - 1];
            if (x1 > 0 && y1 > 0) answer += cumulativeSum[x1 - 1][y1 - 1];

            System.out.println(answer);
        }

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

}
