
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] money = new int[n];
        for(int i = 0; i < n; i++){
            money[i] = stoi(st.nextToken());
        }

        int start = 0;
        int end = m-1;

        long sum = 0;

        for(int i = start; i <= end; i++){
            sum += money[i];
        }

        long max = sum;

        while(end < n-1){
            sum -= money[start];
            start++;

            end++;
            sum += money[end];

            max = Math.max(sum, max);
        }

        System.out.println(max);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
