import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        char[] locations = br.readLine().toCharArray();
        boolean[] isUsed = new boolean[N];
        
        int cnt = 0; // 햄버거 먹은 사람 수
        
        for(int i = 0; i < N; i++){
            if(locations[i] == 'P'){
                for(int j = Math.max(0, i-K); j <= Math.min(i+K, N-1); j++){
                    // 아직 안 먹힌 햄버거
                    if(locations[j] == 'H' && !isUsed[j]){
                        isUsed[j] = true; // 햄버거 먹기
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);


    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}