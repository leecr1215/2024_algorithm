import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N]; // 로프가 버틸 수 있는 최대 중량

        for(int i = 0; i < N; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        int max = 0;

        for(int i = 0; i < N; i++){
            // i~N-1까지의 로프를 사용했을 때
            // 버틸 수 있는 중량
            int k = (N-i) * rope[i];

            if(max < k){
                max = k;
            }
        }

        System.out.println(max);



    }
}