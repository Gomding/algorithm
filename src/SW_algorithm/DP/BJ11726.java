package SW_algorithm.DP;

/*

DP 다이나믹 프로그래밍

백준 11726 - 2xn 타일링

https://www.acmicpc.net/problem/11726

 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11726 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] map = new int[1001];

        map[1] = 1;
        map[2] = 2;

        for (int i = 3; i <= n; i++) {
            map[i] = (map[i - 1] + map[i - 2]) % 10007;
        }

        System.out.println(map[n]);
    }
}
