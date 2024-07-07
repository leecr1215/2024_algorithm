import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열 or 부분집합
public class Main {
    static final int PICKED_NUM = 6;
    static int[] arr;
    static int[] picked = new int[PICKED_NUM];
    static int k;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        while(!(line = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(line);

            k = Integer.parseInt(st.nextToken());


            arr = new int[k];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            combination(0, 0);
            System.out.println();
        }

    }

    public static void combination(int start, int cnt){
        if(cnt == PICKED_NUM){
            for(int i = 0; i < PICKED_NUM; i++){
                System.out.print(picked[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < k; i++){
            picked[cnt] = arr[i];
            combination(i + 1, cnt + 1);
        }
    }

}