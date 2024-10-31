
import java.io.*;
import java.util.*;

public class 플레이페어_암호 {

    public static class Pair {
        char a;
        char b;

        public Pair(char a, char b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString(){
            return "(" + a + ", " + b + ")";
        }
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map = new char[5][5];
    static HashMap<Character, Node> alphaMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.next();
        String key = sc.next();

        makeArr(key);
        makeTwoWords(message);
        encryption();

        System.out.println(sb);
    }

    

    public static void makeArr(String key){
        boolean[] used = new boolean[26];
        int A = (int)'A';

        int x = 0;
        int y = 0;

        for(int i = 0; i < key.length(); i++){
            char alpha = key.charAt(i);
            if(used[((int)alpha)-A]) continue;

            map[x][y] = alpha;
            alphaMap.put(alpha, new Node(x, y));
            used[((int)alpha)-A] = true;

            if(alpha == 'J' || alpha == 'I'){
                used[((int)'J')-A] = true;
                used[((int)'I')-A] = true;
            }
            
            if(y == 4) {
                x++;
                y = 0;
            }
            else{
                y++;
            }
        }

        for(int i = 0; i < 26; i++){
            if(x >= 5) break;

            if(used[i]) continue;

            map[x][y] = (char)(A+i);
            alphaMap.put(map[x][y], new Node(x, y));
            used[i] = true;

            if((char)(A+i) == 'J' || (char)(A+i) == 'I'){
                used[((int)'J')-A] = true;
                used[((int)'I')-A] = true;
            }
            
            if(y == 4) {
                x++;
                y = 0;
            }
            else{
                y++;
            }
            
        }

    }
    
    static ArrayList<Pair> words = new ArrayList<>();
    public static void makeTwoWords(String message){
        int idx = 0;
        
        while(idx < message.length() - 1){
            char a = message.charAt(idx);
            char b = message.charAt(idx+1);

            if(a == 'X' && b == 'X'){
                Pair pair = new Pair(a, 'Q');
                words.add(pair);
            }else if(a == b){
                Pair pair = new Pair(a, 'X');
                words.add(pair);
            }else{
                // 둘이 다른 경우
                Pair pair = new Pair(a, b);
                words.add(pair);
                idx++;
            }

            idx++;
        }

        if(idx == message.length()-1){ // 남은 경우
            words.add(new Pair(message.charAt(idx), 'X'));
        }
        
    }

    static StringBuilder sb = new StringBuilder();
    public static void encryption(){
        for(Pair pair : words){

            Node firstWord = alphaMap.get(pair.a);  // 첫번째 글자의 위치
            Node secondWord = alphaMap.get(pair.b); // 두번째 글자의 위치
            
            if(firstWord.x == secondWord.x){
                sb.append(map[firstWord.x][(firstWord.y + 1) % 5]);
                sb.append(map[secondWord.x][(secondWord.y + 1) % 5]);
            }else if(firstWord.y == secondWord.y){
                sb.append(map[(firstWord.x + 1) % 5][firstWord.y]);
                sb.append(map[(secondWord.x + 1) % 5][secondWord.y]);
            }else {
                sb.append(map[firstWord.x][secondWord.y]);
                sb.append(map[secondWord.x][firstWord.y]);
            }
        }
    }


    public static void printMap(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
