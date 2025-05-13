import java.util.Scanner;

public class Main {

    static int N;
    static int[] picked;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        picked = new int[N];
        arr = new int[N];
        visited = new boolean[N];

        for(int i = 1; i <= N; i++){
            arr[i-1] = i;
        }



        permutation(0);
    }

    public static void permutation(int cnt){

        if(cnt == N){
            for(int i = 0; i < N; i++){
                System.out.print(picked[i]+ " ");
            }
            System.out.println();
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                picked[cnt] = arr[i];
                visited[i] = true;

                permutation(cnt + 1);

                visited[i] = false;
            }
        }
    }

}
