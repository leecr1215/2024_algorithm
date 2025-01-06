import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int X = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] visitCnt = new int[N];
        for(int i = 0; i < N; i++){
            visitCnt[i] = stoi(st.nextToken());
        }

        int[] accum = new int[N];
        accum[0] = visitCnt[0];

        for(int i = 1; i < N; i++){
            accum[i] = accum[i-1] + visitCnt[i];
        }

        // 1 5 7 12 13
        int p1 = 0;
        int p2 = X;
        int max = accum[X-1];

        int cnt = 1;

        while(p2 < N){
            int people = accum[p2] - accum[p1];

            if(people > max){
                max = people;
                cnt = 1;
            }else if(people == max){
                cnt++;
            }

            p1++;
            p2++;
        }

        if(max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(cnt);
        }


    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}