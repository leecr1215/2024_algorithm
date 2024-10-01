import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] result;
    static boolean[] visited;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        result = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 정점으로부터 갈 수 있는 정점을 BFS로 체크
        for(int i = 0; i < N; i++){
            visited = new boolean[N];
            bfs(i);
        }

        printResult();

    }

    public static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int vertex = queue.poll();

            // vertex에서 도달할 수 있는 정점들 구하기
            for(int i = 0; i < N; i++){
                if(map[vertex][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;

                    // start 에서 i도 도달 가능하다는 얘기
                    result[start][i] = 1;
                }
            }
        }

    }

    public static void printResult(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


}