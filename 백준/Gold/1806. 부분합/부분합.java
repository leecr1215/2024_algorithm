import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int S = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int[] accum = new int[N+1];

        for(int i = 0; i < N; i++){
            nums[i] = stoi(st.nextToken());
            accum[i+1] = accum[i] + nums[i];
        }

        twoPointer(N, S, accum);

    }

    public static void twoPointer(int N, int S, int[] accum){
        int min = N;
        boolean isOk = false;

        int s = 0;
        int e = 1;

        while(s <= N && e <= N){
            int sum = accum[e] - accum[s];

            if(sum < S){
                e++;
            }else{
                min = Math.min(min, e-s);
                isOk = true;
                s++;
            }
        }

        System.out.println(isOk? min : 0);


    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}