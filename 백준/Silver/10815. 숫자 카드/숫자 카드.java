import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] cards;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());

            boolean hasNum = findNumInCards(num);

            if(hasNum){
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);

    }

    public static boolean findNumInCards(int targetNum){
        int left = 0;
        int right = N-1;
        int mid = (left + right) / 2;

        while(left <= right) {
            int curVal = cards[mid];

            if (curVal == targetNum) {
                return true;
            } else if (curVal < targetNum) {
                // 타겟이 더 큼
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }


        return false;
    }
}