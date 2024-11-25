import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        long[] len = new long[N-1];
        long[] city = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++){
            len[i] = stol(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            city[i] = stol(st.nextToken());
        }

        long sum = 0;
        long min = city[0];
        long tempSum = len[0];

        for(int i = 1; i < N-1; i++){
            if(min >= city[i]){
                sum += min * tempSum;
                min = city[i];
                tempSum = 0;
            }

            tempSum += len[i];
        }

        sum += min * tempSum;

        System.out.println(sum);
    }

    public static long stol(String str){
        return Long.parseLong(str);
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}