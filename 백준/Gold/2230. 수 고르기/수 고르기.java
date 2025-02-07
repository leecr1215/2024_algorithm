import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = stoi(br.readLine());
        }

        Arrays.sort(A);

        twoPointer(N, M, A);

    }

    public static void twoPointer(int N, int M, int[] A){
        int min = Integer.MAX_VALUE;

        int s = 0;
        int e = 0;

        while(s < N && e < N){
            int diff = A[e] - A[s];

            if(diff < M){
                e++;
            }else{
                min = Math.min(min, diff);
                s++;
            }
        }

        System.out.println(min);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}