import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = stoi(st.nextToken());
        }

        final int MAX_NUM = 100_001;
        int[] cnts = new int[MAX_NUM];

        int maxLen = -1;

        int left = 0;
        int right = 0;

        while(right < N){

            while(right < N && cnts[nums[right]] + 1 <= K){
                cnts[nums[right]]++;
                right++;
            }

            maxLen = Math.max(maxLen, right-left);

            cnts[nums[left]]--;
            left++;

        }


        System.out.println(maxLen);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}