import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static int N;
    static int[] S,W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        StringTokenizer st;

        S = new int[N]; // 내구도
        W = new int[N]; // 무게

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            S[i] = stoi(st.nextToken());
            W[i] = stoi(st.nextToken());
        }

        dfs(0);

        System.out.println(max);


    }


    /**
     *
     * @param cnt : 내가 든 계란 idx
     */
    public static void dfs(int cnt){
        if(cnt == N){
            int eggCnt = 0;
            for(int i = 0; i <N; i++){
                if(S[i] <= 0){
                    eggCnt++;
                }
            }

            max = Math.max(max, eggCnt);
            return;
        }

        boolean allBroken = true;
        for(int i = 0; i < N; i++){
            if(cnt == i) continue;
            if(S[i] <= 0) continue;
            if(S[cnt] <= 0) continue;

            allBroken = false;

            // 계란 치기
            S[cnt] -= W[i];
            S[i] -= W[cnt];

            dfs(cnt+1);

            // 계란 되돌리기
            S[cnt] += W[i];
            S[i] += W[cnt];
        }

        if(allBroken || S[cnt] <= 0){
            dfs(cnt+1);
        }


    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}