import java.util.*;

public class GPT식_숫자_비교 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] nums = new String[N];

        for(int i = 0; i < N; i++){
            nums[i] = sc.next();
        }

        Arrays.sort(nums,(a, b)->{
            String[] as = a.split("\\.");
            String[] bs = b.split("\\.");

            if(Integer.parseInt(as[0]) == Integer.parseInt(bs[0])){
                if(as.length == 1){
                    return -1; // 그대로
                } else if(bs.length == 1){
                    return 1; // 변경
                }
                return Integer.parseInt(as[1]) - Integer.parseInt(bs[1]);
            }

            return Integer.parseInt(as[0]) - Integer.parseInt(bs[0]);
        });

        for(int i = 0; i < N; i++){
            System.out.println(nums[i]);
        }
    }
}

