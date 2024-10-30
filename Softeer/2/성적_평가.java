import java.io.*;
import java.util.*;

public class 성적_평가 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = stoi(br.readLine()); // 참가자 수
        
        StringTokenizer st;
        
        int[] result = new int[N];
        int[] resultSorted = new int[N];
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int[] score = new int[N];
            int[] scoreSorted = new int[N];

            for(int j = 0; j < N; j++){
                score[j] = stoi(st.nextToken());
                scoreSorted[j] = score[j];
                result[j] += score[j];
                resultSorted[j] += score[j];
            }

            Arrays.sort(scoreSorted);
            
            for(int j = 0; j < N; j++){
                int rank = getRank(score[j], scoreSorted);

                sb.append(N - rank); 

                if(j < N-1) sb.append(" ");
            }
            
            sb.append("\n");
        }

        // 최종 result의 순위도 구해주기
        Arrays.sort(resultSorted);
        for(int i = 0; i < N; i++){
            int rank = getRank(result[i], resultSorted);

            sb.append(N - rank); 

            if(i < N-1) sb.append(" ");
        }

        System.out.println(sb);
    }

    // 특정 값의 가장 오른쪽 인덱스 리턴
    public static int getRank(int target, int[] sortedArr){
        int start = 0;
        int end = N;

        while(start < end){
            int mid = (start + end) / 2;

            if(target < sortedArr[mid]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        
        return start - 1;
            
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
