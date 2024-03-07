import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr, picked;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N]; // 1~N의 수를 담고 있는 배열
        visited = new boolean[N];
        picked = new int[M];

        for(int i = 0; i < N; i++){
            arr[i] = i+1;
        }

        permutation(0);
        
    }

    // N개 중에 M개 뽑기s
    static void permutation(int cnt){
        if(cnt == M){
            for(int i = 0; i < M; i++){
                System.out.print(picked[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if (visited[i]) continue;

            picked[cnt] = arr[i];
            visited[i] = true;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
}