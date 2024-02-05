import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> numbers = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");

        for(int i = 0; i < strs.length; i++){
            int cnt = Integer.parseInt(strs[i]);
            if(!numbers.containsKey(cnt)){
                numbers.put(cnt, 0);
            }
            numbers.put(cnt, numbers.get(cnt) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] targets = br.readLine().split(" ");

        for(int i = 0; i < targets.length; i++){
            int target = Integer.parseInt(targets[i]);
            int targetCnt = 0;

            if(numbers.containsKey(target)){
                targetCnt = numbers.get(target);
            }

            sb.append(targetCnt).append(" ");
        }
        System.out.print(sb.toString());
    }
}