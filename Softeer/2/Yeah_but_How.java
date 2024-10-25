import java.io.*;
import java.util.*;

/*
1. 열린 괄호 다음에 닫힌 괄호가 나오면 중간에 1 넣기
2. 닫힌 괄호 다음에 바로 열린 괄호가 나오면 중간에 + 넣기


*/
public class Yeah_but_How {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(i == str.length()-1){
                sb.append(c);
            }
            
            else{
                sb.append(c);
                if(c == '(' && str.charAt(i+1) == ')'){
                    sb.append(1);
                }else if(c == ')' && str.charAt(i+1) == '('){
                    sb.append('+');
                }
            }
        }

        System.out.println(sb);
        
    }
}
