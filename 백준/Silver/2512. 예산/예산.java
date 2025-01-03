import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());

        int[] money = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i = 0; i < N; i++){
            money[i] = stoi(st.nextToken());
            sum += money[i];
        }

        Arrays.sort(money);

        int M = stoi(br.readLine());

        if(sum <= M){
            // 모든 요청 배정 가능
            System.out.println(money[N-1]);
        }else{
            // 이분 탐색으로 정수 상한액 계산
            int upperLimit = binarySearch(N, M, money);
            System.out.println(upperLimit);
        }

    }

    // UPPER BOUND
    public static int binarySearch(int N, int M, int[] money){
        int left = 0;
        int right = money[N-1] + 1;

        while (left < right){
            int mid = (left + right) / 2;

            int sum = getSum(mid, money);

            if(sum > M){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left - 1;
    }

    public static int getSum(int limit, int[] money){
        int sum = 0;

        for(int i = 0; i < money.length; i++){
            if(money[i] < limit){
                sum += money[i];
            }else{
                sum += limit;
            }
        }

        return sum;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}