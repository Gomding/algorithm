package SW_algorithm;

/*

DP 다이나믹 프로그래밍

백준 11727 - 2 x n 타일링 2

https://www.acmicpc.net/problem/11727

문제
2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

예제 입력 1
2
예제 입력 2
8
예제 입력 3
12

예제 출력 1
3
예제 출력 2
171
예제 출력 3
2731

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11727 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i <= N; i++) {

            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;

        }

        System.out.println(dp[N]);

    }
}
