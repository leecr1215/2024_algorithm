import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static LinkedList<Character> list = new LinkedList<>();
    public static ListIterator<Character> iterator;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            list.add(c);
        }

        int M = Integer.parseInt(br.readLine());

        iterator = list.listIterator();

        // 커서 맨 위로 이동시키기
        while (iterator.hasNext()){
            iterator.next();
        }

        for(int i = 0; i < M; i++){
            execute(br.readLine());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(char c : list){
            bw.write(c);
        }

        bw.flush();
        bw.close();
    }
    public static void execute(String command){

        char type = command.charAt(0);

        switch(type){
            case 'L':
                if(iterator.hasPrevious()){ // 이전 값이 있으면 (맨 앞이 아니면)
                    iterator.previous();
                }
                break;
            case 'D':
                if(iterator.hasNext()){ // 다음 값이 있으면 (맨 뒤가 아니면)
                    iterator.next();
                }
                break;
            case 'B':
                if(iterator.hasPrevious()) { // 이전 값이 있으면 (맨 앞이 아니면)
                    iterator.previous();
                    iterator.remove();
                }
                break;
            case 'P':
                char alpha = command.charAt(2);
                iterator.add(alpha);
                break;
            default:
                break;
        }
    }
}