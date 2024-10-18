import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] paper = new int[101][101];

        int n = sc.nextInt(); // 색종이 수

        for(int t = 0; t < n; t++){
            int x = 90 - sc.nextInt();
            int y = sc.nextInt();

            for(int i = 0 ; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    paper[i+x][j+y] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i <= 100; i++){
            for(int j = 0; j <= 100; j++){
                if(paper[i][j] == 1) cnt++;
            }
        }

        System.out.println(cnt);
    }
}