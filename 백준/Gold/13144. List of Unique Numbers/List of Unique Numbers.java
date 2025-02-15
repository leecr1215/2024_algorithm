import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = stoi(st.nextToken());
        }

        long result = 0;


        boolean[] visited = new boolean[100_001];

        int start = 0;

        for(int end = 0; end < N; end++){
            if(visited[nums[end]]){
                // 등장했던 수
                // start를 nums[e]가 나올 때까지 계속 뒤로 미루기
                //
                while(start < end){
                    result += end-start;

                    if(nums[start] == nums[end]){
                        start++;
                        break;
                    }

                    visited[nums[start]] = false;
                    start++;
                }
            }else{
                visited[nums[end]] = true;
            }
        }

        // 남은 부분들도 더해주기
        for(int i = start; i < N; i++){
            result += N-i;
        }

        System.out.print(result);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}