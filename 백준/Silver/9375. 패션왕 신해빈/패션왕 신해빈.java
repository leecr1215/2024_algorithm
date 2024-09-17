import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                System.out.println(0);
                continue;
            }

            // 옷의 종류와 개수 저장
            HashMap<String, Integer> map = new HashMap<>();

            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String type = st.nextToken();

                if(map.containsKey(type)){
                    map.put(type, map.get(type)+1);
                }else{
                    map.put(type, 1);
                }

            }

            int result = 1;

            for(int cnt : map.values()){
                result = result * (cnt + 1);
            }

            System.out.println(result - 1);


        }
    }

}