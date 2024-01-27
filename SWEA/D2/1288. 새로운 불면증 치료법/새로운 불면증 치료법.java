import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 비트마스킹
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());


            int k = 0; // 양 번호
            int visited = 0;

            while (true){
                //k * N하기
                char[] sheepIdx = Integer.toString(++k * N).toCharArray();

                // 양 번호 체크
                for(int i = 0; i < sheepIdx.length; i++){
                    int num = sheepIdx[i] - '0';
                    visited = visited | (1 << num);
                }

                // 0~9까지 모든 숫자를 봤는지 체크
                if(checkAllNumber(visited)) break;
            }

            sb.append("#").append(t).append(" ").append(k*N).append("\n");
        }

        System.out.println(sb.toString());
    }

    static final int standardNum = (1 << 10) - 1;
    public static boolean checkAllNumber(int targetNum){
        return targetNum == standardNum;
    }
}