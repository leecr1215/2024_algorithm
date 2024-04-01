import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] picked;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        picked = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        permutation(0);

        for(String str : set){
            System.out.println(str);
        }

    }
    static Set<String> set = new LinkedHashSet<>();
    public static void permutation(int cnt){
        if(cnt == M){
            for(int num : picked){
                sb.append(num).append(" ");
            }
            set.add(sb.toString());
            sb.setLength(0);
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;

            picked[cnt] = arr[i];
            visited[i] = true;

            permutation(cnt + 1);

            visited[i] = false;
        }
    }


}