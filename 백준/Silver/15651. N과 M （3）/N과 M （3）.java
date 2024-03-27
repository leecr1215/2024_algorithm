import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] picked;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        picked = new int[M];

        for(int i = 0; i < N; i++){
            arr[i] = i + 1;
        }

        duplicatePermutation(0);

        System.out.println(sb.toString());
    }

    static void duplicatePermutation(int cnt){
        if(cnt == M){
            for(int num : picked){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            picked[cnt] = arr[i];
            duplicatePermutation(cnt + 1);
        }
    }
}