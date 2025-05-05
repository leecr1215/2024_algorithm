
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = stoi(br.readLine());

        int[] accum = new int[n+1];
        int[] min = new int[n+1];

        accum[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            accum[i] = stoi(st.nextToken());
        }

        min[0] = accum[0];
        int max = -1000;
        for(int i = 1; i <= n; i++){
            accum[i] = accum[i-1] + accum[i];
            min[i] = Math.min(min[i-1], accum[i]);

            max = Math.max(max, accum[i]-min[i-1]);
        }



        System.out.println(max);
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
