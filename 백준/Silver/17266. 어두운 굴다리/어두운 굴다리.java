import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        M = stoi(br.readLine());

        X = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            X[i] = stoi(st.nextToken());
        }

        int max = Math.max(X[0], N-X[M-1]);
        for(int i = 1; i < M; i++){
            max = Math.max(max, (int) Math.ceil((X[i] - X[i - 1]) / 2.0));
        }

        System.out.println(max);


    }


    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}