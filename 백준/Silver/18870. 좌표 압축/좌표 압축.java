import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class Point{
        int index;
        int value;

        public Point(int index, int value){
            this.index = index;
            this.value = value;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Point[] sortedArr = new Point[N];
        int[] resultArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sortedArr[i] = new Point(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(sortedArr, (p1, p2) -> p1.value - p2.value);
        int idx = 0;

        for(int i = 0; i < N; i++){
            Point p = sortedArr[i];
            resultArr[p.index] = idx;

            if(i != N-1 && p.value != sortedArr[i+1].value){
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int val : resultArr){
            sb.append(val).append(" ");
        }

        System.out.println(sb);
    }
}