import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] picked;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        picked = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        permutation(0);

        sb.setLength(0);
        for(String str : set){
            sb.append(str).append("\n");
        }

        System.out.println(sb.toString());

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
            picked[cnt] = arr[i];
            permutation(cnt + 1);
        }
    }

}