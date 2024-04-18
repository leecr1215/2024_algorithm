import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        // 서로 갖고 있는 영어 단어 개수 파악
        int[] alphas1 = new int[26];
        int[] alphas2 = new int[26];

        for(int i = 0; i < str1.length(); i++){
            alphas1[str1.charAt(i)-'a'] += 1;
        }

        for(int i = 0; i < str2.length(); i++){
            alphas2[str2.charAt(i)-'a'] += 1;
        }

        int cnt = 0;

        for(int i = 0; i < 26; i++){
            cnt += Math.abs(alphas1[i]-alphas2[i]);
        }

        System.out.println(cnt);

    }
}