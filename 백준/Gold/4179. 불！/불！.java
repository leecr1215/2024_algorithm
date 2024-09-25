import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int R,C;
    static char[][] map;
    static int[][]timeJ;
    static int[][]timeF;

    static Queue<Node> queueJ = new ArrayDeque<>();
    static Queue<Node> queueF = new ArrayDeque<>();

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        timeJ = new int[R][C];
        timeF = new int[R][C];


        for(int i = 0; i < R; i++){
            char[] row = br.readLine().toCharArray();

            for(int j = 0; j < C; j++){
                map[i][j] = row[j];

                // 시간 초기화
                timeF[i][j] = -1;
                timeJ[i][j] = -1;

                if(row[j] == 'J'){
                    queueJ.add(new Node(i, j));
                    timeJ[i][j] = 1;
                }

                else if(row[j] == 'F'){
                    queueF.add(new Node(i, j));
                    timeF[i][j] = 1;
                }
            }

        }

        int result = 1;

        // bfs 하기 전, 지훈이가 이미 가장자리에 있으면 출력
        Node jihoon = queueJ.peek();
        if(isEdge(jihoon.x, jihoon.y)){
            System.out.println(result);
        }else{
            result = bfs();

            if(result == -1){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(result);
            }
        }

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int bfs(){
        int result = -1;

        // 1. 불 이동시키기
        while(!queueF.isEmpty()){
            Node fire = queueF.poll();

            for(int i = 0; i < 4; i++){
                int nx = fire.x + dx[i];
                int ny = fire.y + dy[i];

                // 범위 벗어났을 때
                if(outOfRange(nx, ny)) continue;

                // 벽일 때
                if(isWall(nx, ny)) continue;

                // 이미 불이 난 곳일 때
                if(isFireArea(nx, ny)) continue;

                queueF.add(new Node(nx, ny));
                timeF[nx][ny] = timeF[fire.x][fire.y] + 1;
            }
        }

        // 2. 지훈이 이동시키기
        while(!queueJ.isEmpty()){
            Node ji = queueJ.poll();

            for(int i = 0; i < 4; i++){
                int nx = ji.x + dx[i];
                int ny = ji.y + dy[i];

                // 범위 벗어날 때
                if(outOfRange(nx, ny)) continue;

                // 벽일 때
                if(isWall(nx, ny)) continue;

                // 이미 지훈이가 방문한 곳일 때
                if(timeJ[nx][ny] >= 1) continue;

                // 지금 시간을 기준으로, 이미 불이 났던 곳일 때
                int nextTime = timeJ[ji.x][ji.y] + 1;
                if(isFireArea(nx, ny) && timeF[nx][ny] <= nextTime) continue;

                queueJ.add(new Node(nx, ny));
                timeJ[nx][ny] = nextTime;

                // 미로 탈출 가능한지 확인
                if(isEdge(nx, ny)){
                    result = nextTime;
                    return result;
                }

            }
        }
        

        return result;
    }

    // 범위에 벗어나는 경우
    public static boolean outOfRange(int nx, int ny){
        return nx < 0 || nx >= R || ny < 0 || ny >= C;
    }

    // 벽인 경우
    public static boolean isWall(int nx, int ny){
        return map[nx][ny] == '#';
    }

    // 불이 난 칸인 경우
    public static boolean isFireArea(int nx, int ny){
        return timeF[nx][ny] >= 1;
    }


    // 미로의 가장 자리인지 여부 리턴
    // 미로 탈출 가능
    public static boolean isEdge(int x, int y){
        return x == 0 || x == R-1 || y == 0 || y == C-1;
    }

}