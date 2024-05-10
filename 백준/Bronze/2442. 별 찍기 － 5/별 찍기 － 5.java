import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int fullStar = 2 * N - 1;

        for(int i = 1; i <= N; i++){
            int starCnt = 2 * i - 1;
            int blankCnt = (fullStar - starCnt) / 2;

            printBlank(blankCnt);
            printStar(starCnt);

            enter();
        }
    }

    public static void printBlank(int n){
        for(int i = 0; i < n; i++){
            System.out.print(' ');
        }
    }

    public static void printStar(int n){
        for(int i = 0; i < n; i++){
            System.out.print('*');
        }
    }

    public static void enter(){
        System.out.println();
    }


}