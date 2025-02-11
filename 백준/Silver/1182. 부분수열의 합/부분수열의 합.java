import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,S;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = stoi(st.nextToken());
        }

        visited = new boolean[N];

        subSet(0);


        System.out.println(result);
    }

    static int result = 0;
    public static void subSet(int cnt){
        if(cnt == N){
            long sum = 0;
            boolean check = false;
            for(int i = 0; i < N; i++){
                if(!visited[i]) continue;
                sum += arr[i];
                check = true;
            }
            if(check && sum == S) result++;
            return;
        }

        visited[cnt] = true;
        subSet(cnt+1);

        visited[cnt] = false;
        subSet(cnt+1);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}