import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for(int t = 0; t < T; t++){
            int N = stoi(br.readLine());

            st = new StringTokenizer(br.readLine());

            int[] nums = new int[N];


            for(int i = 0; i < N; i++){
                nums[i] = stoi(st.nextToken());
            }

            long sum = 0;
            int max = 0;
            for(int i = N-1; i >= 0; i--){
                if(max <= nums[i]){
                    max = nums[i];
                }else{
                    sum += (max - nums[i]);
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }



}