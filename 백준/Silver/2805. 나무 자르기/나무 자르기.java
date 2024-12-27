import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            trees[i] = stoi(st.nextToken());
        }

        Arrays.sort(trees);

        int height = binarySearch(N, M, trees);

        System.out.println(height);

    }

    // UPPER BOUND
    public static int binarySearch(int N, int M, int[] trees){
        int left = 0;
        int right = trees[N - 1] + 1;

        while(left < right){
            int mid = (left + right) / 2;

            long cutLen = cutTree(mid, trees);

            if(cutLen < M){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left - 1;

    }

    public static long cutTree(int height, int[] trees){
        long sum = 0;
        for(int i = 0; i < trees.length; i++){
            if(trees[i] - height > 0) {
                sum += trees[i] - height;
            }
        }

        return sum;
    }




    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}