import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        String[] words = new String[N];
        for(int i = 0; i < N; i++){
            words[i] = br.readLine();
        }

        String target = words[0];
        int[] targetCnt = new int[26];

        for(int i = 0; i < target.length(); i++){
            targetCnt[target.charAt(i) - 'A']++;
        }

        for(int i = 1; i < N; i++){
            String word = words[i];
            int[] wordCnt = new int[26];

            for(int j = 0; j < word.length(); j++){
                wordCnt[word.charAt(j) - 'A']++;
            }

            int diff = 0;
            for(int d = 0; d < 26; d++){
                diff += Math.abs(targetCnt[d] - wordCnt[d]);
            }


            if(word.length() == target.length() && diff <= 2){
                result++;
            }
            else if(word.length() != target.length() && diff <= 1){
                result++;
            }
        }

        System.out.println(result);
    }
}