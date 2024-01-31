import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// 처음 -가 나오고 그 다음 -가 나오기 전까지 더하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minusArr = br.readLine().split("-"); // - 기준으로 나누기

        // 최종 결과
        int result = 0;

        for(int i = 0; i < minusArr.length; i++){
            String[] plusArr = minusArr[i].split("\\+"); // + 기준으로 나누기

            int sum = 0; // + 부호를 갖고있는 number 저장하는 변수

            for(int j = 0; j < plusArr.length; j++){
                sum += Integer.parseInt(plusArr[j]);
            }

            if(i == 0){ // - 로 나누어진 배열의 가장 앞 인덱스에 들어있는 원소는 더해주어야 함
                result += sum;
            }else{
                result -= sum;
            }
        }

        System.out.println(result);
    }
}