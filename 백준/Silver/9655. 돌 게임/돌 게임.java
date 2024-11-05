import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt = N / 3;
        N = N % 3;

        while(N > 0){
            N--;
            cnt++;
        }

        if(cnt % 2 == 0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }
}