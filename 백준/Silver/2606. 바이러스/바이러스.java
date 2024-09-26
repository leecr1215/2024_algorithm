import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> computers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // 연결되어 있는 컴퓨터 쌍

        visited = new boolean[n+1];

        computers = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            computers.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            computers.get(u).add(v);
            computers.get(v).add(u);
        }

        int cnt =  spreadVirus(1);

        System.out.println(cnt);
    }

    public static int spreadVirus(int startComputer){
        int cnt = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        // 1번 컴퓨터 바이러스 걸림
        visited[startComputer] = true;
        queue.add(startComputer);

        while(!queue.isEmpty()){
            int computer = queue.poll();

            ArrayList<Integer> list = computers.get(computer);

            for(int number : list){
                if(!visited[number]){
                    queue.add(number);
                    cnt++;
                    visited[number] = true;
                }
            }
        }

        return cnt;
    }
}