import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int cnt = 0;
        int result = 0;
        boolean[] isAlive = new boolean[N+1];
        Arrays.fill(isAlive, true);

        for(int i = 2; i <= N; i++){
            if(isAlive[i]){
                // i의 배수 지우기
                for(int j = i; j <= N; j+=i){
                    if(isAlive[j]){
                        isAlive[j] = false;
                        cnt++;

                        if(cnt == K){
                            result = j;
                            break;
                        }
                    }

                }

                if(result != 0) break;
            }

            // 모든 수를 지웠다면 그만!!
            if(allNumberDeleted(isAlive)){
                break;
            }
        }

        System.out.println(result);

    }

    public static boolean allNumberDeleted(boolean[] isAlive){
        for(int i = 0; i < isAlive.length; i++){
            if(isAlive[i]) return false;
        }

        return true;
    }
}
