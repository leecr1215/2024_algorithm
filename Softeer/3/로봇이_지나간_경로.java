
import java.io.*;
import java.util.*;

public class 로봇이_지나간_경로 {

    public static class Node{
        int x;
        int y;
        int dir;

        public Node(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[] firstDir = {'^', '>', 'v', '<'};
    static char[][] map;
    static int a, b;
    static int robotCnt = 0; // 로봇이 방문한 칸수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = stoi(st.nextToken());
        b = stoi(st.nextToken());

        map = new char[a+1][b+1];
        for(int i = 0; i < a; i++){
            Arrays.fill(map[i], '.');
        }


        for(int i = 1; i <= a; i++){

            char[] temp = br.readLine().toCharArray();
            for(int j = 1; j <= b; j++){
                map[i][j] = temp[j-1];
            }
        }


        List<Node> startNodes = new ArrayList<>();
        for(int i = 1; i <= a; i++){
            for(int j = 1; j <= b; j++){
                if(map[i][j] == '#'){
                    robotCnt++;
                    int cnt = 0;
                    int dir = -1;

                    for(int d = 0; d < 4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(nx >= 0 && nx <= a && ny >= 0 && ny <= b){
                            if(map[nx][ny] == '#'){
                                cnt++;
                                dir = d;
                            }

                        }
                    }


                    if(cnt == 1){
                        startNodes.add(new Node(i, j, dir));
                    }
                }
            }
        }

        // 명령어의 개수
        int min = Integer.MAX_VALUE;
        String resultCommand = "";
        Node resultNode = new Node(0, 0, 0);

        for(Node node : startNodes){
            String command = getCommand(node);

            if(command.length() < min){
                min = command.length();
                resultCommand = command;
                resultNode = node;
            }
        }

        System.out.println(resultNode.x + " " + resultNode.y);
        System.out.println(firstDir[resultNode.dir]);
        System.out.println(resultCommand);


    }

    public static String getCommand(Node startNode){
        String command = "";
        int cnt = 1; // 현재까지 방문한 곳의 개수 저장

        int x = startNode.x;
        int y = startNode.y;
        int dir = startNode.dir;

        while(cnt < robotCnt){

            for(int i = -1; i <= 1; i++){
                int nDir = dir + i; // 다음 방향

                if(nDir < 0) nDir = 3;
                else if(nDir > 3) nDir = 0;

                int nx = x + dx[nDir];
                int ny = y + dy[nDir];

                if(nx >= 1 && nx <= a && ny >= 1 && ny <= b && map[nx][ny] == '#'){
                    dir = nDir;
                    cnt+=2;

                    if(i == -1) command += "L";
                    else if(i == 1) command += "R";

                    command += "A";

                    x += dx[dir]*2;
                    y += dy[dir]*2;

                    break;
                }

            }

        }


        return command;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void printArr(char[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
