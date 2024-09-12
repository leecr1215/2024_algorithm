import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sequence = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;

        int cnt = 0;


        while(true){
            if(sum > M){
                sum -= sequence[left++];
            }else if(sum == M){
                // target 값과 같을 때!
                cnt++;
                sum -= sequence[left++];
            }else{
                // target 값보다 값이 작음
                if(right == N) break;
                sum += sequence[right++];
            }



        }

        System.out.println(cnt);
    }
}