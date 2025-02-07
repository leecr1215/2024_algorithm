import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int N = str1.length();
        int M = str2.length();
        int K = str3.length();

        int[][][] LCS = new int[N+1][M+1][K+1];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int k = 0; k < K; k++){
                    if(str1.charAt(i) == str2.charAt(j) && str2.charAt(j) == str3.charAt(k)){
                        LCS[i+1][j+1][k+1] = LCS[i][j][k] + 1;
                    }else{
                        LCS[i+1][j+1][k+1] = Math.max(Math.max(LCS[i][j+1][k+1], LCS[i+1][j][k+1]), LCS[i+1][j+1][k]);
                    }
                }
            }
        }

        System.out.println(LCS[N][M][K]);

    }
}