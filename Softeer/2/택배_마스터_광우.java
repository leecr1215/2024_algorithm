import java.io.*;
import java.util.*;

public class 택배_마스터_광우 {
    static int N, M, K;
    static int[] rail;
    static int[] picked;
    static boolean[] visited;

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 레일의 개수
        M = sc.nextInt(); // 택배 바구니 무게
        K = sc.nextInt(); // 일의 시행 횟수

        rail = new int[N];
        picked = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            rail[i] = sc.nextInt();
        }

        
        permutation(0);

        System.out.println(min);
    }

    // N개 중에 N개 뽑기
    public static void permutation(int cnt){
        if(cnt == N){
            // 이 조합으로 K번 일할 때 드는 무게를 계산
            work();
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            
            picked[cnt] = rail[i];
            visited[i] = true;

            permutation(cnt + 1);

            visited[i] = false;
        }
        
    }

    public static void work(){
        int weight = 0;
        int idx = 0;

        for(int i = 0; i < K; i++){ // K 번 일기
            int sum = 0;
            while(true){
                if(sum + picked[idx] <= M){
                    sum += picked[idx++];
                    
                }else{
                    break;
                }
                
                if(idx >= N){
                    idx = 0;
                }
            }

            weight += sum;
        }



        if(weight < min){
            min = weight;
        }
        
    }
}
