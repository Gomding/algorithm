package SW_algorithm.DP;

/*

DP 백준 2225 - 합분해

https://www.acmicpc.net/problem/2225

문제
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.

덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.

입력
첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.

출력
첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.

예제 입력 1
20 2

예제 출력 1
21

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2225 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[201][201];

        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k] % 1000000;

                }
            }
        }

        System.out.println(dp[K][N]);
    }
}
