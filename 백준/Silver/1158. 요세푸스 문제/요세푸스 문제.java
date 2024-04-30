import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        int i = 0;
        int[] newArr = new int[n];

        while(list.size() >= k){
            // k-1개까지 뽑아서 뒤로 넣기
            // k번째 데이터는 remove

            for(int j = 0; j < k-1; j++){
                list.add(list.removeFirst());
            }

            newArr[i++] = list.removeFirst();
        }

        while(!list.isEmpty()){
            int size = list.size();

            for(int j = 0; j < k-size-1; j++){
                list.add(list.removeFirst());
            }

            newArr[i++] = list.removeFirst();
        }

        System.out.println(Arrays.toString(newArr).replace("[", "<").replace("]", ">"));
    }
}