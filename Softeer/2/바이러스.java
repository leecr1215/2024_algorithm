import java.io.*;
import java.util.*;

public class 바이러스 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long K = sc.nextLong();
        long P = sc.nextLong();
        long N = sc.nextLong();

        for(int i = 0; i < N; i++){
            K = (K * P) % 1000_000_007;
        }

        System.out.println(K);
    }
}
