import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] paper;
    static int white;
    static int blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        StringTokenizer st = null;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0,0,N);

        System.out.println(white);
        System.out.println(blue);
    }

    /**
     *
     * @param x
     * @param y
     * @param size
     * 전부 같으려면 size*size 거나 0
     */
    static void cut(int x, int y, int size){
        int sum = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sum += paper[i+x][j+y];
            }
        }

        if(!(sum == size*size || sum == 0)){
            cut(x, y,size/2);
            cut(x, y + size/2, size/2);
            cut(x + size/2, y, size/2);
            cut(x + size/2, y + size/2, size/2);
        }

        if(sum == 0){
            white++;
        }else if(sum == size*size){
            blue++;
        }
    }
}