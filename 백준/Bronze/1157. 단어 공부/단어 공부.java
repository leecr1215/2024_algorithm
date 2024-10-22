import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toUpperCase();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int cnt = 1;
            if(map.containsKey(c)){
                cnt = map.get(c) + 1;
            }

            map.put(c, cnt);
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (k1, k2) -> map.get(k2)- map.get(k1));

        char result = keys.get(0);

        if(map.size() > 1 && map.get(keys.get(0)).equals(map.get(keys.get(1)))){
            result = '?';
        }

        System.out.println(result);

    }
}