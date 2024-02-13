import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while((str = br.readLine())!=null){
                int N = Integer.parseInt(str);
                sb.setLength(0);

                for(int i = 0; i < Math.pow(3, N); i++){
                    sb.append("-");
                }

//                System.out.println(line.length());

                makeCantorSet(0, sb.length());
                System.out.println(sb.toString());
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    static void makeCantorSet(int startIdx, int len){
//        System.out.println(startIdx + ", " + len + ", " + sb.toString());

        if(len == 1){
            return;
        }

        int subStrLen = len / 3;


//        System.out.println("subStrLen: " + subStrLen);

        // 왼쪽
        makeCantorSet(startIdx, subStrLen);

        // 중간
        for(int i = subStrLen; i < subStrLen * 2; i++){
            sb.setCharAt(startIdx + i, ' ');
        }


        // 오른쪽
        makeCantorSet(startIdx + subStrLen * 2, subStrLen);

    }
}