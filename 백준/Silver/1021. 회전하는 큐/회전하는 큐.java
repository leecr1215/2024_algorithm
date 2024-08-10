import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minCnt = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());


        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            deque.add(i);
        }

        for(int i = 0; i < M; i++){
            String target = st.nextToken();
            int targetIdx = 0;

            Iterator iterator = deque.iterator();

            while(iterator.hasNext()){
                if(iterator.next().toString().equals(target)){
                    break;
                }
                targetIdx++;
            }

            if(targetIdx < deque.size() - targetIdx){
                // 왼쪽으로 회전시키기
                while(deque.peekFirst() != Integer.parseInt(target)){
                    deque.add(deque.poll());
                    minCnt++;
                }

            }else{
                // 오른쪽으로 회전시키기
                while(deque.peekFirst() != Integer.parseInt(target)){
                    deque.addFirst(deque.pollLast());
                    minCnt++;
                }
            }

            // 맨 앞에 있는 target 뽑기
            deque.pollFirst();
        }

        System.out.println(minCnt);
    }
}