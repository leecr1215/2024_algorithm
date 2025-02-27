import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        int time = bfs(N,K);

        System.out.println(time);

    }

    static final int MIN = 0;
    static final int MAX = 100_000;
    public static int bfs(int from, int to){
        int[] time = new int[MAX + 1];
        Arrays.fill(time, Integer.MAX_VALUE);

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(from);
        time[from] = 0;

        while(!queue.isEmpty()){
            int num = queue.poll();

            // 순간이동은 시간이 들지 않으니까 순간이동 먼저!
            if(num > 0 && num * 2 <= MAX && time[num*2] > time[num]){
                time[num*2] = time[num];
                queue.add(num*2);
            }

            // x-1
            if(num - 1 >= MIN && time[num-1] > time[num]+1){
                time[num-1] = time[num] + 1;
                queue.add(num-1);
            }

            // x+1
            if(num + 1 <= MAX && time[num+1] > time[num]+1){
                time[num+1] = time[num] + 1;
                queue.add(num+1);
            }
        }

        return time[to];
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}