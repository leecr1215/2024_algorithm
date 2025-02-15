import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int end = 0;

        while(start < N){
            if(end == N){
                result += end - start;
                start++;
            }
            else{
                if(visited[nums[end]]){
                    // 중복된 수 등장!
                    result += end - start;

                    visited[nums[start]] = false;
                    start++;

                }else{
                    visited[nums[end]] = true;
                    end++;
                }
            }
        }


        System.out.print(result);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}