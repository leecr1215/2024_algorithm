import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] lans;
    static int K, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        lans = new int[K];
        for(int i = 0; i < K; i++){
            lans[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lans);

        System.out.println(findMaxLengthLan());


    }

    static long findMaxLengthLan(){
        long left = 1;
        long right = lans[K-1];


        while(left <= right){
            long mid = (left + right) / 2;
            // mid로 잘라보기
            int cnt = 0;
            for(int i = 0; i < K; i++){
                cnt += (lans[i] / mid);
            }

            if(cnt < N){
                // 더 많이 잘라야함
                // mid가 줄어들어야 함
                right = mid - 1;
            }else {
                // 적합하지만 더 긴 랜선으로 자를 수 있으면 잘라야함
                left = mid + 1;
            }
        }

        return right;
    }
}