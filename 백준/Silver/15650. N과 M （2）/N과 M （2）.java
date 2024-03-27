import java.util.Scanner;

public class Main {
    static int N,M;
    static int[] arr;
    static int[] picked;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        picked = new int[M];
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = i + 1;
        }

        combination(0, 0);
    }

    /**
     *
     * @param start : 원본 배열에서 뽑기 시작할 index
     * @param cnt : 지금까지 뽑은 개수
     */
    static void combination(int start, int cnt){
        if(cnt == M){
            for(int num : picked){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < N; i++){
            picked[cnt] = arr[i];
            combination(i + 1, cnt + 1);
        }
    }
}