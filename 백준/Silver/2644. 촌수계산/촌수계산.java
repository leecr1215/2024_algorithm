import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // list에 들어있다는 건 서로 1촌이라는 의미
    static int n;
    static LinkedList<LinkedList<Integer>> list = new LinkedList<>();

    public static class Node {
        int num;
        int cnt; // 촌수

        public Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         n = stoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i <= n; i++){
            list.add(new LinkedList<>());
        }

        int p1 = stoi(st.nextToken());
        int p2 = stoi(st.nextToken());

        int m = stoi(br.readLine());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int parent = stoi(st.nextToken());
            int child = stoi(st.nextToken());

            list.get(parent).add(child);
            list.get(child).add(parent);
        }

        int result = bfs(p1, p2);

        System.out.println(result);


    }

    public static int bfs(int p1, int p2){
         int result = -1;

         boolean[] visited = new boolean[n+1];
        Queue<Node> queue = new ArrayDeque<>();

        visited[p1] = true;
        queue.add(new Node(p1, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            LinkedList<Integer> relation = list.get(node.num);

            for(int people: relation){
                if(!visited[people]){
                    queue.add(new Node(people, node.cnt+1));
                    visited[people] = true;

                    if(people == p2){
                        result = node.cnt + 1;
                        break;
                    }
                }
            }

            if(result != -1) break;

        }


         return result;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}
