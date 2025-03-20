import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken()); // 접시의 수
        int d = stoi(st.nextToken()); // 초밥의 가짓수
        int k = stoi(st.nextToken()); // 연속해서 먹는 접시의 수
        int c = stoi(st.nextToken()); // 쿠폰 번호

        int[] dishes = new int[N];
        for(int i = 0; i < N; i++){
            dishes[i] = stoi(br.readLine());
        }

        int max = 1;

        int s = 0;
        int e = k-1;

        int[] fishes = new int[d+1];
        fishes[c] = 1;

        for(int i = s; i <= e; i++){
            int type = dishes[i];
            fishes[type] += 1;

            if(fishes[type]==1) {
                max++;
            }
        }


        int cnt = max;
        while(s < N) {
            // 원래 s자리 제거
            int type = dishes[s];
            fishes[type] -= 1;
            if(fishes[type] == 0) cnt--;

            s += 1;
            e = e + 1 >= N ? e + 1 - N : e + 1;

            // 새로 생긴 e자리 추가
            type = dishes[e];
            fishes[type] += 1;
            if(fishes[type] == 1) cnt++;


            if(cnt > max){
                max = cnt;
            }
        }

        System.out.println(max);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
