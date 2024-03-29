import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] picked;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        picked = new int[M];

        for(int i = 0; i < N; i++){
            arr[i] = i + 1;
        }

        duplicatePermutation(0);

        System.out.println(sb.toString());
    }

    // N개 중에 M개 뽑기
    static void duplicatePermutation(int cnt){
        if(cnt == M){
            for(int num : picked){
               sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(cnt != 0){
                if(picked[cnt - 1] > arr[i]) continue;
            }
            picked[cnt] = arr[i];
            duplicatePermutation(cnt + 1);
        }

    }
}