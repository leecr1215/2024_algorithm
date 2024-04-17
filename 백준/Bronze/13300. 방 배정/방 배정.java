import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int K = Integer.parseInt(st.nextToken()); // 한 방에 배정할 수 있는 최대 인원 수

        int[][] grade = new int[7][2]; // 각 학년 별로 여학생, 남학생 명 수 카운트

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            grade[Y][S] += 1;
        }

        int roomCnt = 0;

        for(int i = 1; i <= 6; i++){

            for(int j = 0; j < 2; j++){
                if(grade[i][j]!=0){
                    roomCnt += (int)(Math.ceil((double)grade[i][j] / K));
                }
            }
        }

        System.out.println(roomCnt);

    }
}