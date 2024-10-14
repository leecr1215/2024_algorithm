import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = M; i <= N; i++){
            if(isPrime(i)){
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static boolean isPrime(int num){
        if(num == 1) return false;
        if(num == 2) return true;

        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }

        return true;

    }
}