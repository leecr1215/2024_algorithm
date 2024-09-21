import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 과목의 수강 가능 인원
        int L = Integer.parseInt(st.nextToken()); // 대기 목록의 길이

        HashSet<String> set = new LinkedHashSet<>();

        for(int i = 0; i < L; i++){
            String number = br.readLine();

            if(set.contains(number)){
                set.remove(number);
            }

            set.add(number);

        }

        StringBuilder sb = new StringBuilder();
        for(String num : set){
            if(K == 0) break;

            sb.append(num).append("\n");
            K--;

        }

        System.out.print(sb);
    }
}