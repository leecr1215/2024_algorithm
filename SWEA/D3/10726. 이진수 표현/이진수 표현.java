import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int TC = Integer.parseInt(br.readLine());

        for(int t = 1; t <= TC; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int checkBit = (1 << N) -1;

            if(checkBit == (M & checkBit)){
                // 모두 1로 켜진 것!!!
                System.out.println("#"+t+" "+"ON");
            }else {
                System.out.println("#" + t + " " + "OFF");
            }

        }

    }
}