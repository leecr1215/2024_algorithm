import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static class Country{
        int gold;
        int silver;
        int bronze;

        public Country(int gold, int silver, int bronze){
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        Country target = new Country(0,0,0);

        Country[] countries = new Country[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int countryNum = stoi(st.nextToken());
            int gold = stoi(st.nextToken());
            int silver = stoi(st.nextToken());
            int bronze = stoi(st.nextToken());

            countries[i] = new Country(gold, silver, bronze);

            if(countryNum == K){
                target = new Country(gold, silver, bronze);
            }
        }

        Arrays.sort(countries, (c1, c2) -> {
            if(c1.gold == c2.gold){
                if(c1.silver == c2.silver){
                    return c2.bronze - c1.bronze;
                }else{
                    return c2.silver - c1.silver;
                }
            }else{
                return c2.gold - c1.gold;
            }
        });

        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(countries[i].gold == target.gold && countries[i].silver == target.silver && countries[i].bronze == target.bronze){
                System.out.println(++cnt);
                break;
            }else{
                cnt++;
            }
        }

    }

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
}