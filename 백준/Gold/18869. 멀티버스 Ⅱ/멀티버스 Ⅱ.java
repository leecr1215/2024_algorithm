import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 각 우주마다 행성의 순위 매기기
 * 그걸로 비교
 *
 * 동일한 크기인 경우, 같은 슨위로!!
 */

public class Main {
    static int M,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());

        int[][] spaces = new int[M][N];
        int[][] sortedSpaces = new int[M][N];
        int[][] rank = new int[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                spaces[i][j] = stoi(st.nextToken());
                sortedSpaces[i][j] = spaces[i][j];
            }

            Arrays.sort(sortedSpaces[i]);
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                rank[i][j] = getRank(sortedSpaces[i], spaces[i][j]);
            }
        }
        
        int cnt = 0;
        
        // 행성별로 비교
        for(int i = 0; i < M; i++){
            for(int j = i+1; j < M; j++){
                boolean isSame = true;

                for(int k = 0; k < N; k++){
                    if(rank[i][k] != rank[j][k]){
                        isSame = false;
                        break;
                    }
                }

                if(isSame) cnt++;
            }
        }

        System.out.println(cnt);


    }

    // LOWER BOUND
    public static int getRank(int[] arr, int target){
        int min = 0;
        int max = arr.length;

        while(min < max){
            int mid = (min + max) /  2;

            if(arr[mid] < target){
                min = mid + 1;
            }else{
                max = mid;
            }
        }


        return min;
    }


    public static int stoi(String str){
        return Integer.parseInt(str);
    }

}