import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String result = strfry(st.nextToken(), st.nextToken());

            System.out.println(result);

        }

    }


    public static String strfry(String str1, String str2){
        final String POSSIBLE = "Possible";
        final String IMPOSSIBLE = "Impossible";

        if(str1.length() < str2.length()) {
            return IMPOSSIBLE;
        }

        // str1에 등장한 알파벳 개수 저장
        int[] alphaCnt = new int[26];

        for(int i = 0; i < str1.length(); i++){
            char alpha = str1.charAt(i);

            alphaCnt[alpha-'a'] += 1;
        }

        for(int i = 0; i < str2.length(); i++){
            char alpha = str2.charAt(i);

            alphaCnt[alpha-'a'] -= 1;
        }

        for(int i = 0; i < 26; i++){
            if(alphaCnt[i] != 0){
                return IMPOSSIBLE;
            }
        }

        return POSSIBLE;
    }
}