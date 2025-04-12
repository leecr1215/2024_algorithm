
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L;
    static LinkedList<Node> apples = new LinkedList<>();
    static LinkedList<Info> directionChangeInfos = new LinkedList<>();

    public static class Info{
        int time;
        char c;

        public Info(int time, char c){
            this.time = time;
            this.c = c;
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static class Snake {
        Queue<Node> locations = new ArrayDeque<>();
        int d;
        
        public Snake(){
            locations.add(new Node(0, 0));
            this.d = 1; // 오른쪽
        }
    }

    // 상우하좌
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine()); // 보드의 크기

        K = stoi(br.readLine()); // 사과의 개수

        StringTokenizer st;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            apples.add(new Node(stoi(st.nextToken())-1, stoi(st.nextToken())-1));
        }

        L = stoi(br.readLine()); // 뱀의 방향 변환 횟수

        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());

            int X = stoi(st.nextToken());
            char C = st.nextToken().charAt(0);

            directionChangeInfos.add(new Info(X, C));
        }


        execute();

    }
    
    
    public static void execute(){
        Snake snake = new Snake();

        boolean[][] map = new boolean[N][N]; // true면 뱀이 있는 자리
        map[0][0] = true;

        int changeDirectionIdx = 0;

        int headX = 0;
        int headY = 0;

        int time = 0;
        while(true){
            time++;

            // 1. 몸 길이를 늘려 머리를 다음칸에 위치시킨다
            int nx = headX + dx[snake.d];
            int ny = headY + dy[snake.d];
            
            // 2. 만약 벽이거나 자기 자신이랑 부딪히면 끝
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
            if(map[nx][ny] == true) break;
            
            // 3. 이동한 칸에 사과 있는지 확인
            boolean checkApple = false;
            for(Node apple: apples){
                if(apple.x == nx && apple.y == ny){
                    // 사과가 있음!
                    checkApple = true;

                    // 사과 없애기
                    apples.remove(apple);

                    break;
                }
            }

            // 머리 제대로 움직여주기
            map[nx][ny] = true;
            headX = nx;
            headY = ny;
            snake.locations.add(new Node(headX, headY));

            if(!checkApple){ // 사과가 없다면
                Node tail = snake.locations.peek();

                map[tail.x][tail.y] = false;
                snake.locations.poll();
            }

            // 방향 변경할건지 확인
            if(changeDirectionIdx >=  L) continue;

            Info info = directionChangeInfos.get(changeDirectionIdx);
            if(info.time == time){
                // 방향 변경
                if(info.c == 'D'){
                    // 오른쪽으로 90도 회전
                    snake.d = (snake.d + 1) % 4;
                }else{
                    // 왼쪽으로 90도 회전
                    snake.d = snake.d - 1 < 0 ? 3 : snake.d - 1;
                }

                changeDirectionIdx++;
            }

        }

        System.out.println(time);

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
