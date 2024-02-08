import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            int result = binarySearch(targets[i]);

            sb.append(result == -1 ? 0 : 1);
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }

    static int binarySearch(int target){
        int left = 0;
        int right = N - 1;
        int mid;

        while(left <= right){

            mid = (left + right) / 2;
            
            if(arr[mid] == target){
                return mid; // 탐색 완
            }

            if(arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }

        }
    
        return -1; // 탐색 실패
       
    }
}