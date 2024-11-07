import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * 1 -> 2
 * 2 -> 1 3 4
 * 3 -> 2 4 5
 * 4 -> 2 3 5
 * 5 -> 3 4
 *
 */
public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static class Node {
        int v;
        int distance;

        public Node(int v, int distance){
            this.v = v;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());

            int v = stoi(st.nextToken());
            int u = stoi(st.nextToken());

            if(v == -1) break;

            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        int[] scores = new int[N+1];
        for(int i = 1; i <= N; i++){
            scores[i] = getScore(i);
        }

        int minScore = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            if(scores[i] < minScore){
                minScore = scores[i];
                result.clear();
                result.add(i);
            }else if(scores[i] == minScore){
                result.add(i);
            }
        }

        System.out.println(minScore + " " + result.size());
        for(int v : result){
            System.out.print(v + " ");
        }


    }

    public static int getScore(int v){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(v, 0));

        boolean[] visited = new boolean[N+1];
        visited[v] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            ArrayList<Integer> list = graph.get(node.v);
            for(int vertex : list){
                if(!visited[vertex]){
                    queue.add(new Node(vertex, node.distance + 1));
                    visited[vertex] = true;

                    if(allVisited(visited)){
                        return node.distance + 1;
                    }
                }
            }
        }

        return 0;
    }

    public static boolean allVisited(boolean[] visited){
        for(int i = 1; i <= N; i++){
            if(visited[i] == false){
                return false;
            }
        }

        return true;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}