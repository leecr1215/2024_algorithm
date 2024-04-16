import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String result = Integer.toString(A * B * C);

        int[] cnts = new int[10];

        for(int i = 0; i < result.length(); i++){
            int index = result.charAt(i) - '0';
            cnts[index] += 1;
        }

        for(int cnt : cnts){
            System.out.println(cnt);
        }

    }
}