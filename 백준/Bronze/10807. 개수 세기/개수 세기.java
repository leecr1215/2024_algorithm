import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(nums[i] == target) cnt++;
        }

        System.out.println(cnt);

    }
}