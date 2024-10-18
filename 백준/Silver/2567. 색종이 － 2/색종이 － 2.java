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

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 색칠된 부분의 상하좌우를 확인하고, 색칠 안 된 곳의 개수만큼 count
        int cnt = 0;
        for(int i = 0; i <= 100; i++){
            for(int j = 0; j <= 100; j++){
                if(paper[i][j] == 1){
                    // 상하좌우확인
                    for(int d = 0; d < 4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(nx < 0 || nx > 100 || ny < 0 || ny > 100 || paper[nx][ny] == 0 ){
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);

    }
}