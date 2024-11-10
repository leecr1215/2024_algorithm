import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final String END = "end";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String word = br.readLine();

            if(word.equals(END)){
                break;
            }

            checkPwd(word);
        }

    }

    public static void checkPwd(String str){
        if(hasVowels(str) && !isContinuous(str) && !hasSameWord(str)){
            System.out.println(acceptableStr(str));
        }else{
            System.out.println(notAcceptableStr(str));
        }
    }

    public static boolean hasVowels(String str){
        return str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u");
    }

    public static boolean isContinuous(String str){
        for(int i = 0; i <= str.length()-3; i++){
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);
            char c3 = str.charAt(i+2);

            if(isVowel(c1) && isVowel(c2) && isVowel(c3)){
                return true;
            }else if(!isVowel(c1) && !isVowel(c2) && !isVowel(c3)){
                return true;
            }
        }

        return false;
    }

    public static boolean isVowel(Character c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    public static boolean hasSameWord(String str){
        for(int i = 'a'; i < 'z'; i++){
            String concat = (char)i + "" +(char)i;

            if(str.contains(concat) && !concat.equals("ee") && !concat.equals("oo")){
                return true;
            }
        }
        return false;
    }

    public static String acceptableStr(String str){
        return String.format("<%s> is acceptable.", str);
    }

    public static String notAcceptableStr(String str){
        return String.format("<%s> is not acceptable.", str);
    }
}