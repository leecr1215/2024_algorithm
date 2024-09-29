import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n+1];
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();

        for(int i = 0; i <= n; i++){
            list.add(new LinkedList<>());
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            list.get(v).add(u);
            list.get(u).add(v);
        }

        int cnt = 0;
        visited[1] = true;

        // 1번의 친구들
        LinkedList<Integer> friends = list.get(1);
        Queue<Integer> queue = new ArrayDeque<>();
        for(int friend : friends){
            queue.add(friend);
            visited[friend] = true;
            cnt++;
        }

        // 친구의 친구들
        while(!queue.isEmpty()){
            int friend = queue.poll();
            LinkedList<Integer> ffriends = list.get(friend);

            for(int ff : ffriends){
                if(!visited[ff]){
                    cnt++;
                    visited[ff] = true;
                }
            }
        }

        System.out.println(cnt);

    }
}