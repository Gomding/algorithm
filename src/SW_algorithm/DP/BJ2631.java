package SW_algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2631 {

    static int N;
    static int[] children;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        children = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            int num = children[i];
            dp[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                if (num > children[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(N - max);

    }

}
