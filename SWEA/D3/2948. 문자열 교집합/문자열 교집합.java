import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Map<String, Integer> map = new HashMap<>();
            int result = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                map.put(st.nextToken(), 1);
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                if(map.containsKey(st.nextToken())){
                    result++;
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }
}