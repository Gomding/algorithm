package SW_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2133 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] dp = new int[31];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            for (int j = 2; j <= i; j += 2) {
                int standard = j == 2 ? 3 : 2;
                dp[i] += standard * dp[i - j];
            }
        }

        System.out.println(dp[N]);

    }

}
