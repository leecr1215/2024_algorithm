import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String pocketmon = br.readLine();
            map1.put(i, pocketmon);
            map2.put(pocketmon, i);
        }

        StringBuilder sb = new StringBuilder();
        Set<Integer> keys = map1.keySet();

        for(int i = 0; i < M; i++){
            String question = br.readLine();

            if(question.charAt(0) <= '9' && question.charAt(0) >= '0'){
                // 숫자
               sb.append(map1.get(Integer.parseInt(question))).append("\n");
            }else{
                sb.append(map2.get(question)).append("\n");
            }
        }

        System.out.println(sb);
    }
}