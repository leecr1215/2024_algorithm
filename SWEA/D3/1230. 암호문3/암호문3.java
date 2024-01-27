import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            LinkedList<String> cryptogram = new LinkedList<>();

            for(int i = 0; i < N; i++){
                cryptogram.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < M; i++){
                String command = st.nextToken();

                int x = 0;
                int y = 0;

                switch (command) {
                    case "I":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());

                        for (int j = 0; j < y; j++) {
                            cryptogram.add(x++, st.nextToken());
                        }

                        break;
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());

                        for (int j = 0; j < y; j++) {
                            cryptogram.remove(x);
                        }

                        break;
                    case "A":
                        y = Integer.parseInt(st.nextToken());

                        for (int j = 0; j < y; j++) {
                            cryptogram.addLast(st.nextToken());
                        }

                        break;
                }
            }

            sb.append("#").append(t).append(" ");
            for(int i = 0; i < 10; i++){
                sb.append(cryptogram.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}