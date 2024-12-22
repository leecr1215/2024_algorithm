import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = stoi(st.nextToken()); // 조카 수
        int N = stoi(st.nextToken()); // 과자 수

        int sum = 0;
        int[] snacks = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            snacks[i] = stoi(st.nextToken());
            sum += snacks[i];
        }

        Arrays.sort(snacks);

        int len = 0;

        if(M <= sum) {
            len = binarySearch(M, N, snacks);
        }


        System.out.println(len);
    }

    // UPPER BOUND
    public static int binarySearch(int M, int N, int[] snacks){
        int left = 0;
        int right = snacks[N-1] + 1;

        while(left < right){
            int mid = (left + right) / 2;

            if(M > getSnackCnt(mid, N, snacks)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left - 1;
    }

    // len으로 잘랐을 때 나오는 과자 조각의 개수
    public static int getSnackCnt(int len, int N, int[] snacks){
        int sum = 0;

        for(int i = 0; i < N; i++){
            sum += snacks[i] / len;
        }

        return sum;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}