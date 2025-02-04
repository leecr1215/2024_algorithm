import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] money;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        money = new int[N];
        int max = 0;
        int sum = 0;
        for(int i = 0; i < N; i++){
            money[i] = stoi(br.readLine());
            if(max < money[i]) max = money[i];
            sum += money[i];
        }

        int K = binarySearch(max, sum);


        System.out.println(K);

    }

    // LOWER BOUND
    public static int binarySearch(int min, int max){
        int left = min;
        int right = max;

        while(left < right){
            int mid = (left + right) / 2;

            if(M < calcCnt(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }

    public static int calcCnt(int won){
        int cnt = 1;
        int curMoney = won;

        int i = 0;
        while(i < N){
            if(money[i] <= curMoney){
                curMoney -= money[i++];
            }else{
                // 모자람
                curMoney = won;
                cnt++;
            }
        }

        return cnt;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}