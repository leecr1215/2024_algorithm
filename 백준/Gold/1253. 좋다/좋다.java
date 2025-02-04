import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int N;
    static boolean[] visited;

    public static class Node{
        int i;
        int j;


        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = stoi(st.nextToken());
        }

        Arrays.sort(arr);

        if(N <= 2) System.out.println(0);
        else{
            int cnt = 0;
            visited = new boolean[N];

            for(int i = 0; i < N; i++){
                boolean isAble = twoPointer(i);
                if(isAble) cnt++;
            }

            System.out.println(cnt);

        }

    }


    public static boolean twoPointer(int targetIdx){
        int target = arr[targetIdx];
        boolean isAble = false;

        int s = 0;
        int e = N-1;

        while(s < e){
            int sum = arr[s]+arr[e];

            if(sum < target){
                s++;
            }else if(sum > target){
                e--;
            }else{
                if(s == targetIdx){
                    s++;
                }else if(e == targetIdx){
                    e--;
                }else{
                    isAble = true;
                    break;
                }
            }

        }

        return isAble;
    }


    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}