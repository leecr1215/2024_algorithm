import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[] A;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = stoi(st.nextToken());
        }

        visited = new boolean[N];

        dfs(500, 0);

        System.out.println(result);

    }

    public static void dfs(int weight, int cnt){

        if(cnt == N){
            result++;
            return;
        }

        if(weight < 500){
            return;
        }


        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;

                dfs(weight + A[i] - K, cnt+1);

                visited[i] = false;
            }
        }
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}