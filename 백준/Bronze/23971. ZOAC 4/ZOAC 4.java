import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int cnt = 0;
        for(int i = 0; i < H; i+=N+1){
            for(int j = 0; j < W; j+=M+1){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}