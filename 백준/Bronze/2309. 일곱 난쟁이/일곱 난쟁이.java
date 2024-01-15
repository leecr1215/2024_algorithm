import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 9개 중에 7개 뽑기
// 조합
public class Main {
    static int[] realDwarfs = new int[7];
    static int[] dwarfs = new int[9];
    static final int R = 7;
    static final int N = 9;
    static boolean findDwarfs = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < N; i++){
            dwarfs[i] = Integer.parseInt(br.readLine());
        }

        combination(0,0);
    }

    public static void combination(int start, int cnt){
        if(cnt == R){
            int sum = 0;
            for(int j = 0; j < R; j++){
                sum += realDwarfs[j];
            }

            if(sum == 100){
                findDwarfs = true;
                Arrays.sort(realDwarfs);
                for(int dwarf : realDwarfs){
                    System.out.println(dwarf);
                }

            }

            return;
        }

        for(int i = start; i < N; i++){
            if(!findDwarfs) {
                realDwarfs[cnt] = dwarfs[i];
                combination(i + 1, cnt + 1);
            }
        }
    }
}