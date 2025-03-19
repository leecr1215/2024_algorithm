import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static final int N = 5;
    static final int M = 7;
    static char[][] area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        students = new int[M];
        area = new char[N][N];


        for(int i = 0; i < N; i++){
            char[] row = br.readLine().toCharArray();

            for(int j = 0; j < N; j++){
                area[i][j] = row[j];
            }
        }

        combination(0, 0);

        System.out.println(answer);
    }

    static int answer;
    static int[] students;
    public static void combination(int start, int cnt){
        if(cnt == M){
            // 뽑기 완료

            // 이다솜파가 4명 이상인지 확인
            boolean isSomOver4 = calSomOver4();

            if(!isSomOver4) return;

            // 가로 세로로 인접했는지 확인
            boolean isCloser = calCloser();

            if(!isCloser) return;

            answer++;

            return;
        }

        for(int i = start; i < N*N; i++){
            // 0~24중에 뽑기
            students[cnt] = i;
            combination(i + 1, cnt + 1);

        }
    }

    /**
     *
     *
     * @return 7명의 학생 중 이다솜파 학생이 4명 이상인지 여부
     */
    public static boolean calSomOver4(){
        int cnt = 0;

        for(int i = 0; i < M; i++){
            int x = students[i] / N;
            int y = students[i] % N;

            if(area[x][y] == 'S') cnt++;
        }

        return cnt >= 4 ? true : false;
    }


    /**
     * @return 뽑은 학생들이 가로, 세로로 인접했는지 확인
     */
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static boolean calCloser(){

        boolean[] visited = new boolean[M];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(students[0]);
        visited[0] = true;

        while(!queue.isEmpty()){
            int s = queue.poll();   // 학생 번호

            int x = s / N;
            int y = s % N;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                int number = nx * N + ny;

                if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                    for(int j = 0; j < M; j++){
                        if(!visited[j] && students[j] == number){
                            queue.add(number);
                            visited[j] = true;
                            break;
                        }

                    }
                }
            }

        }


        for(int i = 0; i < M; i++){
            if(!visited[i]) return false;
        }

        return true;
    }


    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}



