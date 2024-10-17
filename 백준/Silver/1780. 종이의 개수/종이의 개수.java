import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int minusOne, zero, one;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        paper = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                paper[i][j] = stoi(st.nextToken());
            }
        }

        execute(N,0, 0);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);

    }

    public static void execute(int N, int startX, int startY){
        boolean check = isSameNum(N, startX, startY);
        if(check){
            return;
        }else{
            //startX와 N에 대해서 같은 크기의 종이 9개로 자르기
            /**
             *
             * 만약 N이 9라면?
             * N은 N / 3이 됨
             * (3,0,0) (3, 0,3) (3, 0, 6)
             * (3, 3, 0) (3, 3, 3) (3, 3, 6)
             * (3, 6, 0) (3, 6, 3) (3, 6, 6)
             *
             *
             */
            int nextN = N / 3;
            for(int i = 0; i < N; i+=nextN){
                for(int j = 0; j < N; j+=nextN){
                    execute(nextN, startX + i, startY + j);
                }
            }

        }
    }



    public static boolean isSameNum(int N, int startX, int startY){
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt_1 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int value = paper[startX + i][startY + j];
                if(value == 0){
                    cnt0++;
                }else if(value == 1){
                    cnt1++;
                }else{
                    cnt_1++;
                }
            }
        }

        if(cnt0 == N*N){
            zero++;
            return true;
        }
        if(cnt1 == N*N){
            one++;
            return true;
        }
        if(cnt_1 ==  N * N){
            minusOne++;
            return true;
        }


        return false;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}