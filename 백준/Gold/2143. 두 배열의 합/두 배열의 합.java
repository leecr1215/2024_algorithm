import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1. 각 A와 B의 누적합 구해주기
 * 0 1 4 5 7
 * 0 1 4 6
 *
 * 2. A와 B의 누적합을 활용해서 각각 A와 B에서 나올 수 있는 합의 종류를 map에 저장
 * key : 수, value : 개수
 *
 * 3.둘 중에 key의 길이가 더 작은 걸 기준으로, key를 돌면서 T-key가 다른 쪽의 key에 있는지 확인
 * 있으면 각각의 개수를 곱한 값을 cnt에 더해주기
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = stoi(br.readLine());

        int n = stoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A[] = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = stoi(st.nextToken());
        }

        int m = stoi(br.readLine());
        int B[] = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            B[i] = stoi(st.nextToken());
        }

        // 1. 누적합 구하기
        long[] accumA = new long[n+1];
        long[] accumB = new long[m+1];

        for(int i = 1; i <= n; i++){
            accumA[i] = accumA[i-1] + A[i-1];
        }

        for(int i = 1; i <= m; i++){
            accumB[i] = accumB[i-1] + B[i-1];
        }

        // 2. 누적합 활용한 각 배열 별 부분 합 저장
        Map<Long, Long> mapA = new HashMap<>();
        Map<Long, Long> mapB = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = i+1; j <= n; j++){
                long key = accumA[j] - accumA[i];

                if(mapA.containsKey(key)){
                    mapA.put(key, mapA.get(key)+1);
                }else{
                    mapA.put(key, 1L);
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = i+1; j <= m; j++){
                long key = accumB[j] - accumB[i];

                if(mapB.containsKey(key)){
                    mapB.put(key, mapB.get(key)+1);
                }else{
                    mapB.put(key, 1L);
                }
            }
        }

        long cnt = 0;
        if(mapA.keySet().size() > mapB.keySet().size()){
            // B가 key 종류가 더 적음
            for(long key : mapB.keySet()){
                if(mapA.containsKey(T-key)) {
                    cnt += mapB.get(key) * mapA.get(T-key);
                }
            }
        }else{
            // A가 key 종류가 더 적음
            for(long key : mapA.keySet()){
                if(mapB.containsKey(T-key)) {
                    cnt += mapA.get(key) * mapB.get(T-key);
                }
            }
        }

        System.out.println(cnt);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}