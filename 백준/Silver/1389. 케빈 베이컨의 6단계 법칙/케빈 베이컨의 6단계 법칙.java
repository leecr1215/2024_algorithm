import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] bacon;
    static int N, M;
    static ArrayList<Set<Integer>> graph = new ArrayList<>();

    public static class Node{
        int v;
        int depth;

        public Node(int v, int depth){
            this.v = v;
            this.depth = depth;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        bacon = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph.add(new HashSet<>());
        }

        for(int i = 0; i < M; i++){
           st = new StringTokenizer(br.readLine());

           int v = stoi(st.nextToken());
           int u = stoi(st.nextToken());

           graph.get(v).add(u);
           graph.get(u).add(v);
        }

        for(int i = 1; i <= N; i++){
            bacon[i] = getBaconNumber(i);
        }

        int min = Integer.MAX_VALUE;
        int minVertex = -1;

        for(int i = 1; i <= N; i++){
            if(bacon[i] < min){
                min = bacon[i];
                minVertex = i;
            }
        }

        System.out.println(minVertex);
    }

    public static int getBaconNumber(int start){
        int[] cnts = new int[N+1];
        Queue<Node> queue = new ArrayDeque<>();

        Arrays.fill(cnts, -1);

        cnts[start] = 0;
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            Set<Integer> set = graph.get(node.v);
            for(int v : set){
                if(cnts[v] == -1 || cnts[v] > node.depth + 1){
                    queue.add(new Node(v, node.depth + 1));
                    cnts[v] = node.depth + 1;
                }
            }

            if(isAllVisited(cnts)){
                break;
            }
        }



        int baconNum = 0;
        for(int i = 1; i <= N; i++){
            baconNum += cnts[i];
        }

        return baconNum;
    }


    public static boolean isAllVisited(int[] cnts){
        for(int i = 1; i < cnts.length; i++){
            if(cnts[i] == -1) return false;
        }

        return true;
    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}