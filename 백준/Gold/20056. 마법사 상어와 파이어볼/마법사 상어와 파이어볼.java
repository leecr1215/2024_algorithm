import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static class FireBall{
        int id;
        int x;
        int y;
        int m; // 질량
        int d; // 방향
        int s; // 속력
        boolean isAlive; // 살아있는 여부

        public FireBall(int id, int x, int y, int m, int d, int s, boolean isAlive){
            this.id = id;
            this.x = x;
            this.y = y;
            this.m = m;
            this.d = d;
            this.s = s;
            this.isAlive = isAlive;
        }

    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, K;
    static LinkedList<FireBall> fireBalls = new LinkedList<>();
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int r = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            int m = stoi(st.nextToken());
            int s = stoi(st.nextToken());
            int d = stoi(st.nextToken());

            FireBall fireBall = new FireBall(idx++, r, c, m, d, s, true);

            fireBalls.add(fireBall);
        }

        for(int i = 0; i < K; i++){
            moveFireBalls();
        }

        // 남아있는 파이어볼 질량
        int sum = 0;
        for(FireBall fireBall : fireBalls){
            if(fireBall.isAlive){
                sum += fireBall.m;
            }
        }

        System.out.println(sum);

    }


    // 상 상우 우 우하 하 하좌 좌 좌상
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void moveFireBalls(){

        HashMap<String, LinkedList<FireBall>> map = new HashMap<>();

        for(FireBall fireBall : fireBalls){

            if(fireBall.m == 0){
                fireBall.isAlive = false;
            }

            if(!fireBall.isAlive) continue;

            int d = fireBall.d;
            int nx = fireBall.x + dx[d] * fireBall.s;
            int ny = fireBall.y + dy[d] * fireBall.s;


            if(nx > N) nx = nx % N;
            if(nx < 1) nx = N - (Math.abs(nx) % N);

            if(ny > N) ny = ny % N;
            if(ny < 1) ny = N - (Math.abs(ny) % N);


            fireBall.x = nx;
            fireBall.y = ny;


            String str = nx + "," + ny;


            if(map.containsKey(str)){
                map.get(str).add(fireBall);
            }else{
                LinkedList<FireBall> list = new LinkedList<>();
                list.add(fireBall);
                map.put(str, list);
            }


        }


        for(String str : map.keySet()){
            if(map.get(str).size() >= 2){
                spread(map.get(str));
            }
        }

    }

    // list에는 살아있는 파이어볼만 있음!
    public static void spread(LinkedList<FireBall> list){
        int nm = 0;
        int ns = 0;
        boolean allOdd = true;
        boolean allEven = true;

        int r = list.get(0).x;
        int c = list.get(0).y;

        for(FireBall fireBall : list){
            nm += fireBall.m;
            ns += fireBall.s;

            if(fireBall.d % 2 == 0) allOdd = false;
            else allEven = false;

            // 겹치는 애들은 죽이기
//            fireBalls.get(fireBall.id).isAlive = false;
            fireBall.isAlive = false;
        }


        nm = nm / 5;
        ns = ns / list.size();

        int nd = 1;
        if(allOdd || allEven){
            nd = 0;
        }

        // 질량이 0이면 추가 안 함!
        if(nm == 0) return;

        // 4개의 파이어볼 추가하기
        for(int i = 0; i < 4; i++){
            fireBalls.add(new FireBall(idx++, r, c, nm, nd, ns, true));

            nd += 2;
        }


    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}