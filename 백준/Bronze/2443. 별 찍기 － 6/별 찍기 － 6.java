import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int full = 2 * N - 1;

        for(int i = N; i > 0; i--){
            int starCnt = 2 * i - 1;
            int blankCnt = (full - starCnt) / 2;

            printBlank(blankCnt);
            printStar(starCnt);

            enter();
        }

    }

    public static void printStar(int n){
        for(int i = 0; i < n; i++){
            System.out.print('*');
        }
    }

    public static void printBlank(int n){
        for(int i = 0; i < n; i++){
            System.out.print(' ');
        }
    }

    public static void enter(){
        System.out.println();
    }
}