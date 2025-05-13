import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = stoi(st.nextToken());
        int P = stoi(st.nextToken());

        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());

        int[] minCnt = new int[4];
        for(int i = 0; i < 4; i++){
            minCnt[i] = stoi(st.nextToken());
        }

        int result = 0;

        int start = 0;
        int end = P-1;

        int[] cnt = new int[4];

        // 처음 시도
        for(int i = start; i <= end; i++){
            int idx = DNAToIdx(DNA.charAt(i));

            cnt[idx]++;
        }



        if(canMake(minCnt, cnt)) result++;


        while(end < DNA.length()-1){
            cnt[DNAToIdx(DNA.charAt(start))]--;
            start++;

            end++;
            cnt[DNAToIdx(DNA.charAt(end))]++;

            if(canMake(minCnt, cnt)) result++;
        }

        System.out.println(result);

    }

    public static int DNAToIdx(char DNA){
        if(DNA == 'A'){
            return 0;
        } else if (DNA == 'C') {
            return 1;
        }else if(DNA == 'G'){
            return 2;
        }else{
            return 3;
        }
    }


    public static boolean canMake(int[] minCnt, int[] cnt){
        for(int i = 0; i < 4; i++){
            if(cnt[i] < minCnt[i]){
                return false;
            }
        }
        return true;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
