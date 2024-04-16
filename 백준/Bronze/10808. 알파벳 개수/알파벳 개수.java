import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        final int LEN = 26;
        int[] alphaCnt = new int[LEN];

        for(int i = 0; i < s.length(); i++){
            char alpha = s.charAt(i);

            alphaCnt[alpha - 'a'] += 1;
        }

        for(int cnt : alphaCnt){
            System.out.printf(cnt + " ");
        }
    }
}